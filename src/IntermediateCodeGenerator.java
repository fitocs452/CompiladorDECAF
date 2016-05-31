import DECAF2.DECAF2BaseVisitor;
import DECAF2.DECAF2Parser;
import java.util.ArrayList;
import java.util.Stack;
import org.antlr.v4.runtime.misc.NotNull;

public class IntermediateCodeGenerator<T> extends DECAF2BaseVisitor<Object> {
    
    private IntermediateCodeTable tablaCodigo;
    private TablesGenerator tablas;
    private Scope scopeActual;
    private ArrayList<StackPointer> stack;
    private int contTempVars = 0;
    private ArrayList<String> booleanDataTypes;
    private ArrayList<GlobalStackPointer> stackGlobal; 
    private boolean structDeclaration = false;
    private ArrayList<String> globalStruct;
    private int contadorTemps = 0;
    private int contadorIF = 0;
    private int contadorElse = 0;
    
    private final int BOOL_OFFSET = 4;
    private final int INT_OFFSET = 4;
    private final int CHAR_OFFSET = 4;

    public IntermediateCodeGenerator(TablesGenerator tablas, DECAF2Parser.ProgramaContext tree) {
        this.tablas = tablas;
        
        tablaCodigo = new IntermediateCodeTable(tablas);
        stack = new ArrayList();
        stackGlobal = new ArrayList();
        scopeActual = new Scope();
        globalStruct = new ArrayList();
        
        booleanDataTypes = new ArrayList();
        booleanDataTypes.add("true");
        booleanDataTypes.add("false");
        
        this.visitPrograma(tree);
        Scope.ambitoActual = 0;
        GlobalStackPointer.staticPos = 0;
    }
    
    @Override
    public T visitPrograma(@NotNull DECAF2Parser.ProgramaContext ctx) {
        return (T)super.visitPrograma(ctx);
    }
    
    @Override
    public Object visitArrayVarDeclaration(DECAF2Parser.ArrayVarDeclarationContext ctx) {
        String tipo = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        int lenght = Integer.parseInt(ctx.getChild(3).getText());
        
        if (scopeActual.getName() == 0 || structDeclaration) {
            this.stackGlobal.add(new GlobalStackPointer(INT_OFFSET * lenght, id, tipo));
            
            return super.visitArrayVarDeclaration(ctx);
        }
     
        switch (tipo) {
            case "int":
                this.stack.add(new StackPointer(INT_OFFSET * lenght, id, tipo));
                break;
            case "char":
                this.stack.add(new StackPointer(CHAR_OFFSET * lenght, id, tipo));
                break;
            case "boolean":
                this.stack.add(new StackPointer(BOOL_OFFSET * lenght, id, tipo));
                break;
        }
        
        agregarOffsetSP();
        
        return super.visitArrayVarDeclaration(ctx);
    }

    @Override
    public Object visitSimpleVarDeclaration(DECAF2Parser.SimpleVarDeclarationContext ctx) {
        IntermediateCode codigo = new IntermediateCode();
        String tipo = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        
        if (scopeActual.getName() == 0 || structDeclaration) {
            if (structDeclaration) {
                id += "_" + ctx.getParent().getChild(1).getText();
            }
            this.stackGlobal.add(new GlobalStackPointer(INT_OFFSET, id, tipo));
            
            return super.visitSimpleVarDeclaration(ctx);
        }
        
        switch (tipo) {
            case "int":
                this.stack.add(new StackPointer(INT_OFFSET, id, tipo));
                break;
            case "char":
                this.stack.add(new StackPointer(CHAR_OFFSET, id, tipo));
                break;
            case "boolean":
                this.stack.add(new StackPointer(BOOL_OFFSET, id, tipo));
                break;
        }
        
        agregarOffsetSP();
        
        return super.visitSimpleVarDeclaration(ctx);
    }

    @Override
    public Object visitAssign(DECAF2Parser.AssignContext ctx) {
        boolean isSimpleLocation = true;
        String result = ctx.getChild(0).getText();
        
        if (result.contains("[")) {
            isSimpleLocation = false;
            int indexOfBracket = result.indexOf("[");
            result = result.substring(0, indexOfBracket);
        }
        
        if (isSimpleLocation) {
            result = ((String)visit(ctx.getChild(0)));
            IntermediateCode codigo = new IntermediateCode();
            Symbol simbolo = tablaCodigo.findSymbolInGlobalScope(result, scopeActual);

            if (simbolo != null) {
                GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(result);
                result = "stack_global[" + globalSP.getPos() + "]";
                
                //IntermediateCode code = this.tablaCodigo.searchCodeGlobal(result);
                //result = code.getLabel();
                
            } else {
                result = "stack[" + this.findPosInStackById(result) + "]";
            }
            
            /*
            Se uitlizarán variables que representan las direcciones (dir1, dir2)
            */
            String dir1;
            //System.out.println("e: " + ctx.getChild(2).getText());
            T eval = (T)visit(ctx.getChild(2));
            //System.out.println("e: " + eval);

            if (eval instanceof IntermediateCode ) {
                dir1 = ((IntermediateCode)eval).getRes();
            } else if (eval instanceof ArrayList) {
                if (((ArrayList)eval).get(0) instanceof String) {
                    dir1 = ((String)((ArrayList)eval).get(0));
                } else {
                    String arrayVar = ((IntermediateCode)((ArrayList)eval).get(0)).getRes();
                    dir1 = ((IntermediateCode)((ArrayList)eval).get(0)).getRes();
                    if (arrayVar.contains("[")) {
                        dir1 = this.processArrayVariable(arrayVar);
                    }
                }
            } else {
                dir1 = (String)eval;
            }
            
            if (!dir1.contains("\'") &&
                !dir1.contains("temp") &&
                !booleanDataTypes.contains(dir1) &&
                !dir1.contains("[") &&
                !dir1.contains("global")
            ) {
                try {
                    Integer.parseInt(dir1);
                } catch(Exception e) {
                    Symbol var = tablaCodigo.findSymbolInGlobalScope(dir1, scopeActual);
                    //System.out.println("Simbolo: " + var);
                    if (var != null) {
                        //IntermediateCode code = this.tablaCodigo.searchCodeGlobal(dir1);
                        //dir1 = code.getLabel();
                        GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(dir1);
                        dir1 = "stack_global[" + globalSP.getPos() + "]";
                    } else {
                        int pos = this.findPosInStackById(dir1);
                        dir1 = "stack[" + pos * INT_OFFSET +"]";
                    }
                }
            }
            if (booleanDataTypes.contains(dir1)) {
                if (dir1.equals("true")) {
                    dir1 = "1";
                } else {
                    dir1 = "0";
                }
            }
            
            codigo.setFirstDir(dir1);
            codigo.setOperator("=");
            
            codigo.setRes(result);
            tablaCodigo.addCodigo(codigo);
            this.contTempVars = 0;
        }
        
        if (!isSimpleLocation) {
            String res = "";
            ArrayList loctArray = (ArrayList)visit(ctx.getChild(0));
            String nombreVar = (String)loctArray.get(0);
            int posArray = (int)loctArray.get(1);
            if (posArray == -1) {
                posArray = 0;
            }
            //System.out.println("PosArray: " + posArray);

            IntermediateCode codigo = new IntermediateCode();
            Symbol var = tablaCodigo.findSymbolInGlobalScope(nombreVar, scopeActual);
            //System.out.println("Var founded: " + var);
            if (var != null) {
                GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(result);
                
                //System.out.println("tipo: " + tipo);
                int index = globalSP.getPos() + posArray * INT_OFFSET;
                //System.out.println(globalCode.getLabel());
                //System.out.println("Index calculado: " + index);
                res = "stack_global[" + index + "]";
                //System.out.println("Res: " + res);
            } else {
                res = "stack[" + (this.findPosInStackById(nombreVar) + posArray * INT_OFFSET) + "]";
            }
            
            String dir1 = "";
            T returnValue = (T)visit(ctx.getChild(2));
            
            if (returnValue instanceof ArrayList ) {
                if (((ArrayList) returnValue).get(0) instanceof IntermediateCode) {
                    String arrayVar = ((IntermediateCode)((ArrayList)returnValue).get(0)).getRes();
                    dir1 = ((IntermediateCode)((ArrayList)returnValue).get(0)).getRes();
                    if (arrayVar.contains("[")) {
                        dir1 = this.processArrayVariable(arrayVar);
                    }
                } else {
                    dir1 = ((String)((ArrayList) returnValue).get(0));
                }
            } else if (returnValue instanceof IntermediateCode) {
                dir1 = ((IntermediateCode)returnValue).getRes();
            } else {
                dir1 = (String)returnValue;
            }
            
            if (!dir1.contains("\'") &&
                !dir1.contains("temp") &&
                !booleanDataTypes.contains(dir1) &&
                !dir1.contains("[")
            ) {
                try {
                    Integer.parseInt(dir1);
                } catch (Exception e) {
                    Symbol var_1 = tablaCodigo.findSymbolInGlobalScope(dir1, scopeActual);
                    if (var_1 != null) {
                        //IntermediateCode code = this.tablaCodigo.searchCodeGlobal(dir1);
                        //dir1 = code.getLabel();
                        GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(dir1);
                        dir1 = "global_stack[" + globalSP.getPos() + "]";
                    } else { 
                        int pos = this.findPosInStackById(dir1);
                        dir1 = "stack[" + pos + "]";
                    }
                }
            }
            
            codigo.setFirstDir(dir1);
            codigo.setOperator("=");
            codigo.setRes(res);
            
            tablaCodigo.addCodigo(codigo);
            
            this.contTempVars = 0;
        }
        
        return null;
    }
    
    public void agregarOffsetSP() {
        int stackLenght = this.stack.size();
        
        if (stackLenght >= 2) {
            for (int i = stackLenght - 1; i != 0; i--) {
                StackPointer actual = stack.get(i);
                StackPointer prev = stack.get(i - 1);

                int posActual = actual.getPos();
                int posPrev = prev.getPos();

                actual.setPos(posPrev);
                actual.setPos(posActual);
            }
        }
    }

    @Override
    public Object visitWhileS(DECAF2Parser.WhileSContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        super.visitWhileS(ctx);
        
        scopeActual = nuevoScope.getAnterior();
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitElseS(DECAF2Parser.ElseSContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        super.visitElseS(ctx);
        
        scopeActual = nuevoScope.getAnterior();
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIfS(DECAF2Parser.IfSContext ctx) {
        Scope scopeMethod = new Scope();
        
        scopeActual.addScopeChild(scopeMethod);
        scopeMethod.setAnterior(scopeActual);
        scopeActual = scopeMethod;
        //2-0-1
        IntermediateCode codigo = new IntermediateCode();
        String etiqueta = ctx.getChild(0).getText() + "_" + this.contadorIF;
        
        Object expr = this.visit(ctx.getChild(2));
        String type = ctx.getChild(2).getChild(0).getChild(1).getText();
        String verify = "";
        //System.out.println("TYPE: " + type);
        if (expr instanceof ArrayList) {
            for (int i = 0; i < ((ArrayList)expr).size(); i++) {
                IntermediateCode ic = (IntermediateCode)((ArrayList)expr).get(i);
                if (ic != null) {
                    if (i == ((ArrayList)expr).size() - 1) {
                        verify += ic.getFirstDir() + " " + ic.getOperator() + " " + ic.getSecondDir();
                        continue;
                    }
                    verify += ic.getFirstDir() + " " + ic.getOperator() + " " + ic.getSecondDir() + " " + type + " ";
                }
            }
        }
        codigo.setLabel(etiqueta + ": TRUE - EVAL: (" + verify + ")");
        
        tablaCodigo.addCodigo(codigo);
        super.visitIfS(ctx);
        
        System.out.println("VER: " + verify);
        IntermediateCode codigo2 = new IntermediateCode();

        codigo2.setLabel(etiqueta + ": FALSE");
        tablaCodigo.addCodigo(codigo2);
        
        scopeActual = scopeActual.getAnterior();
        StackPointer.globalPos = 0;
        
        return  null;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMethodDeclaration(DECAF2Parser.MethodDeclarationContext ctx) {
        Scope scopeMethod = new Scope();
        
        scopeActual.addScopeChild(scopeMethod);
        scopeMethod.setAnterior(scopeActual);
        scopeActual = scopeMethod;
        
        IntermediateCode codigo = new IntermediateCode();
        String etiqueta = ctx.getChild(1).getText();

        codigo.setLabel(etiqueta + ":");
        tablaCodigo.addCodigo(codigo);
        
        super.visitMethodDeclaration(ctx);
        
        scopeActual = scopeActual.getAnterior();
        StackPointer.globalPos = 0;
        
        return null;
    }

    @Override
    public Object visitStructDeclaration(DECAF2Parser.StructDeclarationContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        if (scopeActual.getName() == 0) {
            structDeclaration = true;
        }
        
        scopeActual = nuevoScope;
        
        super.visitStructDeclaration(ctx);
        
        structDeclaration = false;
        scopeActual = scopeActual.getAnterior();
        StackPointer.globalPos = 0;
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAddDiffExpr(DECAF2Parser.AddDiffExprContext ctx) {
        String firstOpTmp = "";
        String secondOpTmp = "";
        
        String firstOp = "";
        String secondOp = "";
        
        Stack<String> operators = new Stack();
        int countOperators = 0;
        
        for (int i = 0; i < ctx.getChildCount() ;i++) {
            T value = (T) this.visit(ctx.getChild(i));
            if (value instanceof IntermediateCode) {
                countOperators++;                   
                String arrayVar = ((IntermediateCode)value).getRes();
                if (arrayVar.contains("[")) {
                    arrayVar = this.processArrayVariable(arrayVar);
                }
                if (!arrayVar.contains("[")) {
                    arrayVar = this.processSimpleVariable(arrayVar);
                }
                if (arrayVar.isEmpty()) {
                    arrayVar = ((IntermediateCode)value).getRes(); 
                }
                operators.push(arrayVar);
            }
        }
        if (countOperators > 1) {
            firstOpTmp = operators.pop();
            firstOp = firstOpTmp;
        }
        if (firstOpTmp.isEmpty()) {
            Object eval = this.visit(ctx.getChild(0));
            if (eval instanceof IntermediateCode) {
                firstOp = ((IntermediateCode)eval).getRes();
                if (firstOp.contains("[")) {
                    firstOp = processArrayVariable(firstOp);
                }
                if (!firstOp.contains("[")) {
                    firstOp = processSimpleVariable(firstOp);
                }
                if (firstOp.isEmpty()) {
                    firstOp = ((IntermediateCode)eval).getRes(); 
                }
            } else {
                firstOp = (String)this.visit(ctx.getChild(0));
            }
        }
        
        if (countOperators >= 2) {
            secondOpTmp = operators.pop();
            secondOp = secondOpTmp;
        }
        if (firstOpTmp.isEmpty()) {
            Object eval = this.visit(ctx.getChild(2));
            if (eval instanceof IntermediateCode) {
                secondOp = ((IntermediateCode)eval).getRes();
                if (secondOp.contains("[")) {
                    secondOp = processArrayVariable(secondOp);
                }
                if (!secondOp.contains("[")) {
                    secondOp = processSimpleVariable(secondOp);
                }
                if (secondOp.isEmpty()) {
                    secondOp = ((IntermediateCode)eval).getRes(); 
                }
            } else {
                secondOp = (String)this.visit(ctx.getChild(2));
            }
        }
        
        IntermediateCode ic = new IntermediateCode(
                secondOp,
                firstOp,
                ctx.getChild(1).getText()
        );
        
        ic.setRes("temp" + this.contTempVars++);
        this.tablaCodigo.addCodigo(ic);
        //System.out.println("------------*********************----------------");
        
        return ic;
    }

    @Override
    public Object visitUnaryExpr(DECAF2Parser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        } else {
        //System.out.println("CTX: " + ctx.getText());
            return visit(ctx.getChild(1)); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    @Override
    public Object visitMultDivExpr(DECAF2Parser.MultDivExprContext ctx) {
        //System.out.println("MULTjlskjdflas");
        String firstOpTmp = "";
        String secondOpTmp = "";
        
        String firstOp = "";
        String secondOp = "";
        
        Stack<String> operators = new Stack();
        int countOperators = 0;
        
        for (int i = 0; i < ctx.getChildCount() ;i++) {
            T value = (T) this.visit(ctx.getChild(i));
            if (value instanceof IntermediateCode) {
                String arrayVar = ((IntermediateCode)value).getRes();
                if (arrayVar.contains("[")) {
                    arrayVar = this.processArrayVariable(arrayVar);
                }
                if (!arrayVar.contains("[")) {
                    arrayVar = this.processSimpleVariable(arrayVar);
                }
                if (arrayVar.isEmpty()) {
                    arrayVar = ((IntermediateCode)value).getRes(); 
                }
                operators.push(arrayVar);
            }
        }
        
        if (countOperators > 1) {
            firstOpTmp = operators.pop();
            firstOp= firstOpTmp;
        }
        if (firstOpTmp.isEmpty()) {
            //System.out.println("Visitar primero");
            Object eval = this.visit(ctx.getChild(0));
            if (eval instanceof IntermediateCode) {
                firstOp = ((IntermediateCode)eval).getRes();
                if (firstOp.contains("[")) {
                    firstOp = processArrayVariable(firstOp);
                }
                if (!firstOp.contains("[")) {
                    firstOp = processSimpleVariable(firstOp);
                }
                if (firstOp.isEmpty()) {
                    firstOp = ((IntermediateCode)eval).getRes(); 
                }
            } else {
                firstOp = (String)this.visit(ctx.getChild(0));
            }
        }
        
        if (countOperators >= 2) {
            secondOpTmp = operators.pop();
            secondOp= secondOpTmp;
        }
        if (firstOpTmp.isEmpty()) {
            Object eval = this.visit(ctx.getChild(2));
            if (eval instanceof IntermediateCode) {
                secondOp = ((IntermediateCode)eval).getRes();
                if (secondOp.contains("[")) {
                    secondOp = processArrayVariable(secondOp);
                }
                if (!secondOp.contains("[")) {
                    secondOp = processSimpleVariable(secondOp);
                }
                if (secondOp.isEmpty()) {
                    secondOp = ((IntermediateCode)eval).getRes(); 
                }
            } else {
                secondOp = (String)this.visit(ctx.getChild(2));
            }
        }
        
        IntermediateCode ic = new IntermediateCode(
            secondOp,
            firstOp,
            ctx.getChild(1).getText()
        );
        
        ic.setRes("temp" + this.contTempVars++);
        this.tablaCodigo.addCodigo(ic);
        
        return ic;
    }

    @Override
    public Object visitExpression(DECAF2Parser.ExpressionContext ctx) {
        ArrayList returnArray = new ArrayList();
        
        if (ctx.getChildCount() < 2) {
            T valor = (T)visit(ctx.getChild(0));
            if (valor instanceof IntermediateCode) {
                returnArray.add(valor);
                return returnArray;
            } else if (valor instanceof ArrayList) {
                returnArray.addAll((ArrayList) valor);
                return returnArray;
            } else {
                returnArray.add(valor);
                return returnArray;
            }
        }
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            T expr1 = (T)visit(ctx.getChild(i));
            
            if (expr1 instanceof ArrayList) {
               returnArray.addAll((ArrayList)expr1);
            } else if (expr1 instanceof IntermediateCode) {
               returnArray.add(expr1);
            } else {
                returnArray.add(expr1);
            }  
        }
        
        return returnArray;
    }
    
    @Override
    public Object visitChar_literal(DECAF2Parser.Char_literalContext ctx) {
        return super.visitChar_literal(ctx);
    }

    @Override
    public Object visitInt_literal(DECAF2Parser.Int_literalContext ctx) {
        return super.visitInt_literal(ctx);
    }

    @Override
    public Object visitBool_literal(DECAF2Parser.Bool_literalContext ctx) {
        return super.visitBool_literal(ctx);
    }
    
    public int findPosInStackById(String eval) {
        for(StackPointer sp: this.stack) {
            if (sp.getId().equals(eval)) {
                return sp.getPos();
            }
        }
        
        return -1;
    }
    
    public int findPosInGlobalStackById(String eval) {
        for(GlobalStackPointer sp: this.stackGlobal) {
            if (sp.getId().equals(eval)) {
                return sp.getPos();
            }
        }
        
        return -1;
    }
    
    public StackPointer findStackPointerInStack(String identificador){
        for(StackPointer sp: this.stack){
            if (sp.getId().equals(identificador)){
                return sp;
            }
        }
        
        return null;
    }
    
    public GlobalStackPointer findGlobalSPInGlobalStack(String identificador){
       for(GlobalStackPointer sp: this.stackGlobal){
           if (sp.getId().equals(identificador)){
               return sp;
           }
       }
       
       return null;
    }

    @Override
    public Object visitSimpleVariable(DECAF2Parser.SimpleVariableContext ctx) {
        
        return ctx.getText(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public IntermediateCodeTable getTablaCodigo() {
        return tablaCodigo;
    }

    public void setTablaCodigo(IntermediateCodeTable tablaCodigo) {
        this.tablaCodigo = tablaCodigo;
    }

    @Override
    public Object visitValue(DECAF2Parser.ValueContext ctx) {
        IntermediateCode codigo = new IntermediateCode();
        if (ctx.getChild(0).getChild(0).getChildCount() == 1) {
            //System.out.println("return luego de visit: " + this.visit(ctx.getChild(0)));
            codigo.setRes(ctx.getChild(0).getChild(0).getText());
            //System.out.println("1: " + codigo.getRes());
        } else {
            // Aquí hay que sustituir o jalar el valor que tiene el atributo de estructura
            //System.out.println("return luego de visit: " + this.visitLocation((DECAF2Parser.LocationContext)ctx.getChild(0)));
            //codigo.setRes(ctx.getChild(0).getChild(0).getText());
            codigo.setRes((String)this.visitLocation((DECAF2Parser.LocationContext)ctx.getChild(0)));
            //System.out.println("2: " + codigo.getRes());
        }
        
        return codigo; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitArrayVariable(DECAF2Parser.ArrayVariableContext ctx) {
        String nombreVar = ctx.getChild(0).getText();
        int locationSave = Integer.parseInt(ctx.getChild(2).getText());
        
        ArrayList returnArray = new ArrayList();
        returnArray.add(nombreVar);
        returnArray.add(locationSave);
        
        return returnArray;
    }

    @Override
    public Object visitStructLocation(DECAF2Parser.StructLocationContext ctx) {
        Scope scopeLocal = scopeActual;
        if (ctx.getChild(2).getChild(0).getChildCount() > 1) {
            this.globalStruct.add(ctx.getChild(0).getText());
            return super.visitStructLocation(ctx);
            //return this.globalStruct;
        }
        this.globalStruct.add(ctx.getChild(0).getText());
        this.globalStruct.add(ctx.getChild(2).getChild(0).getText());
        
        Structure methodSymbol = null;
        Symbol found = null;
        for (int i = 0; i < globalStruct.size(); i++) {
            if (i == 0) {
                methodSymbol = this.tablas.getTablaEstructura().getStructure(globalStruct.get(i), scopeLocal);
                if (methodSymbol == null) {
                    found = this.tablas.findSymbolInScopes(globalStruct.get(i), scopeLocal);
                }
                //System.out.println("No truena después de i = 0 cmp");
            } else {
                if (methodSymbol != null) {
                    methodSymbol = tablas.findStructureInScopes(((Type)found.getType()).getTypeName(), scopeLocal);
                    //System.out.println("MT: " + methodSymbol);
                } else {
                    methodSymbol = tablas.findStructureInScopes(((Type)found.getType()).getTypeName(), scopeLocal);
                    //System.out.println("ST: " + methodSymbol);
                }
                if (methodSymbol != null) {
                    ArrayList<Symbol> members = methodSymbol.getMembers();
                    //System.out.println("Members: " + members);
                    for (int k = 0; k < members.size(); k++) {
                        Symbol innerSymbol =  members.get(k);
                        if (innerSymbol.getId().equals(globalStruct.get(i))) {
                            //System.out.println("Encontró: " + globalStruct.get(i));
                            found = innerSymbol;
                            scopeLocal = found.getScope();
                        }
                    }
                }
            }
        }
        
        this.globalStruct = new ArrayList();
        String returnSTR = found.getId() + "_" + methodSymbol.getId();
        
        return "stack_global[" +this.findPosInGlobalStackById(returnSTR) + "]";
    }
    
    public String processArrayVariable(String arrayVar) {
        String nombreVar = arrayVar.substring(0, arrayVar.indexOf("["));
        int indexVar = Integer.parseInt(arrayVar.substring(arrayVar.indexOf("[") + 1, arrayVar.indexOf("]")));
        if (indexVar == -1) {
            indexVar = 0;
        }
        
        String returnSTR = nombreVar;
        try {
            StackPointer buscado = this.findStackPointerInStack(nombreVar);
            int i = buscado.getPos();
            int searchStack = this.findPosInStackById(nombreVar) + indexVar * INT_OFFSET;
            return "stack[" + searchStack + "]";
        } catch(Exception e) {
            Symbol gbl = this.tablaCodigo.findSymbolInGlobalScope(nombreVar, scopeActual);
            if (gbl != null) {
                //IntermediateCode globalCode = this.tablaCodigo.searchCodeGlobal(nombreVar);
                GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(nombreVar);
                
                int index = globalSP.getPos() + indexVar * INT_OFFSET;
                return "stack_global[" + index + "]";
            }
        }
        return returnSTR;
    }
    
    public String processSimpleVariable(String simple) {
        String returnSTR = "";
        try {
            StackPointer buscado = this.findStackPointerInStack(simple);
            int i = buscado.getPos();
            int searchStack = this.findPosInStackById(simple);
            
            return "stack[" + searchStack + "]";
        } catch(Exception e) {
            Symbol gbl = this.tablaCodigo.findSymbolInGlobalScope(simple, scopeActual);
            if (gbl != null) {
                //IntermediateCode globalCode = this.tablaCodigo.searchCodeGlobal(simple);
                GlobalStackPointer globalSP = this.findGlobalSPInGlobalStack(simple);

                returnSTR = "stack_global[" + globalSP.getPos() + "]";
            }
        }
        return returnSTR;
    }

    @Override
    public Object visitLocation(DECAF2Parser.LocationContext ctx) {
        //System.out.println("vl: " + ctx.getText());
        Object ret = this.visit(ctx.getChild(0));
        return ret;
        //return this.visit(ctx.getChild(0)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMethodCall(DECAF2Parser.MethodCallContext ctx) {
        for (int i = 1; i < ctx.getChildCount(); i++) {
            T param = (T)this.visit(ctx.getChild(i));
            //System.out.println(param);
            
            if (param instanceof IntermediateCode) {
                IntermediateCode parametro = new IntermediateCode();
                parametro.setFirstDir("PARAM");
                parametro.setSecondDir(((IntermediateCode)param).getRes());
                this.tablaCodigo.addCodigo(parametro);
            }
            
            if (param instanceof ArrayList){
                IntermediateCode parametro = new IntermediateCode();
                parametro.setFirstDir("PARAM");
                if (((ArrayList)param).get(0) instanceof String) {
                    String nombreVAr = (String)((ArrayList)param).get(0);
                    Symbol amb = tablaCodigo.findSymbolInGlobalScope(nombreVAr, scopeActual);
                    if (amb != null) {
                        parametro.setSecondDir("stack_global[" + this.findPosInGlobalStackById(nombreVAr) + "]");
                    } else {
                        parametro.setSecondDir("stack[" + this.findPosInStackById(nombreVAr) + "]");
                    }  
                } else {
                    parametro.setSecondDir(((IntermediateCode)((ArrayList)param).get(0)).getRes());
                }
                this.tablaCodigo.addCodigo(parametro);
            }
        }
        IntermediateCode ic  = new IntermediateCode("CALL", ctx.getChild(0).getText(), "");
        ic.setRes("temp0");
        this.tablaCodigo.addCodigo(ic);
        return  ic;
        //return super.visitMethodCall(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitExp1(DECAF2Parser.Exp1Context ctx) {
        //System.out.println("lol: " + this.visit(ctx.getChild(0)));
        /*System.out.println("ExpressionVisit");
        IntermediateCode codigo = new IntermediateCode();
        String etiqueta = "";

        if (ctx.getChildCount() == 1) {
            System.out.println("Un hijo: " + this.visit(ctx.getChild(0)));
        }
        
        if (ctx.getChildCount() == 3) {
            System.out.println("primer hijo: " + this.visit(ctx.getChild(0)));
            System.out.println(" hijo: " + this.visit(ctx.getChild(2)));
        }*/
        return super.visitExp1(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRelationExpr(DECAF2Parser.RelationExprContext ctx) {
        if (ctx.getChildCount() > 1) {
            T val1 = (T)visit(ctx.getChild(0));
            T val2 = (T)visit(ctx.getChild(2));
            String dir1;
            String dir2;
            if (val1 instanceof IntermediateCode){
                dir1 = ((IntermediateCode)(val1)).getRes();
            }else
                dir1 = (String)val1;

            if (val2 instanceof IntermediateCode){
                dir2 =  ((IntermediateCode)(val2)).getRes();
            }else
                dir2 = (String)val2;

            try {
               int test = Integer.parseInt(dir1);
            } catch(Exception e){
                if (!dir1.contains("[")){
                    Symbol amb = tablaCodigo.findSymbolInGlobalScope(dir1, scopeActual);
                if (amb != null) 
                   dir1 = "stack_global[" + findPosInGlobalStackById(dir1) +"]";
                else
                    dir1 = "stack["+findPosInStackById(dir1)+"]";
                } 

            } try {
                int test = Integer.parseInt(dir2);
            } catch(Exception e) {
                //System.out.println("DIR2: " + dir2);
                int ambito = tablas.findSymbolInAllScopes(dir2, scopeActual).getScope().getName();

                if (ambito == 0)
                    dir2 =  "stack_global[" + this.findPosInGlobalStackById(dir2) +"]";
                else
                    dir2 = "stack["+this.findPosInStackById(dir2)+"]";
            }
            String op = ctx.getChild(1).getText();
            IntermediateCode codigo = new IntermediateCode();
            //System.out.println("dir1 " + dir1);
            //System.out.println("dir2 " + dir2);
            codigo.setFirstDir(dir1);
            codigo.setSecondDir(dir2);
            codigo.setOperator(op);
            codigo.setRes("temp"+this.contadorTemps++);

            return codigo; //To change body of generated methods, choose Tools | Templates.
        }
        
        return super.visitRelationExpr(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEqIneqExpr(DECAF2Parser.EqIneqExprContext ctx) {
        if (ctx.getChildCount() > 1) {
            T val1 = (T)visit(ctx.getChild(0));
            //System.out.println(val1);
            T val2 = (T)visit(ctx.getChild(2));
            //System.out.println(val2);
            String dir1;
            String dir2;
            if (val1 instanceof IntermediateCode){
                dir1 = ((IntermediateCode)(val1)).getRes();
            }else
                dir1 = (String)val1;

            if (val2 instanceof IntermediateCode){
                dir2 =  ((IntermediateCode)(val2)).getRes();
            }else
                dir2 = (String)val2;
          
        try{
            int test = Integer.parseInt(dir1);
        }catch(Exception e){
            if (!dir1.contains("[")){
                Symbol amb = tablaCodigo.findSymbolInGlobalScope(dir1, scopeActual);
            if (amb != null)
                dir1 =  "stack_global[" + this.findPosInGlobalStackById(dir1) +"]";
            else
                dir1 = "stack["+this.findPosInStackById(dir1)+"]";
            }
            
        }
        try{
            int test = Integer.parseInt(dir2);
        }catch(Exception e){
            int ambito = tablas.findSymbolInAllScopes(dir2, scopeActual).getScope().getName();
            if (ambito ==0)
               dir2 = "stack_global[" + this.findPosInGlobalStackById(dir2) +"]";
            else
                dir2+="_"+"label"+"_"+ambito; //TODO: Agregar etiqueta
        }
        String op = ctx.getChild(1).getText();
        IntermediateCode codigo = new IntermediateCode();
             //System.out.println("dir1 " + dir1);
             //System.out.println("dir2 " + dir2);
        codigo.setFirstDir(dir1);
        codigo.setSecondDir(dir2);
        codigo.setOperator(op);
        codigo.setRes("temp"+this.contadorTemps++);
            //System.out.println(codigo);
        return codigo; //To change body of generated methods, choose Tools | Templates.
        }
        return super.visitEqIneqExpr(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAndConditionExpr(DECAF2Parser.AndConditionExprContext ctx) {
        //System.out.println("AND");
        ArrayList returnArray = new ArrayList();
        for (int i = 0;i<ctx.getChildCount();i++){
            T val = (T)visit(ctx.getChild(i));
            //System.out.println(val);
            if (val instanceof ArrayList){
                returnArray.addAll((ArrayList)val);
            }
            if (val instanceof IntermediateCode){
                returnArray.add(val);
            }
            else
                returnArray.add(val);
        }
        
        //System.out.println("RET AND: " + returnArray);
        return returnArray; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEq_op(DECAF2Parser.Eq_opContext ctx) {
        return ctx.getChild(0).getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRel_op(DECAF2Parser.Rel_opContext ctx) {
        return ctx.getChild(0).getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAdd_op(DECAF2Parser.Add_opContext ctx) {
        return ctx.getChild(0).getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMult_op(DECAF2Parser.Mult_opContext ctx) {
        return ctx.getChild(0).getText(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
