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
    
    private final int BOOL_OFFSET = 4;
    private final int INT_OFFSET = 4;
    private final int CHAR_OFFSET = 4;

    public IntermediateCodeGenerator(TablesGenerator tablas, DECAF2Parser.ProgramaContext tree) {
        this.tablas = tablas;
        
        tablaCodigo = new IntermediateCodeTable(tablas);
        stack = new ArrayList();
        stackGlobal = new ArrayList();
        scopeActual = new Scope();
        
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
        
        if (scopeActual.getName() == 0) {
            this.stackGlobal.add(new GlobalStackPointer(INT_OFFSET * lenght, id, tipo));
            /*IntermediateCode codigo = new IntermediateCode();
            
            codigo.setLabel(ctx.getChild(1).getText() + "_global");
            codigo.setIsGlobal(true);
            tablaCodigo.addCodigo(codigo);*/
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
        
        if (scopeActual.getName() == 0) {
            this.stackGlobal.add(new GlobalStackPointer(INT_OFFSET, id, tipo));
            /*codigo.setLabel(ctx.getChild(1).getText() + "_global");
            codigo.setIsGlobal(true);
            tablaCodigo.addCodigo(codigo);*/
            
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
            T eval = (T)visit(ctx.getChild(2));

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
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        super.visitIfS(ctx);
        
        scopeActual = nuevoScope.getAnterior();
        
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
        
        scopeActual = nuevoScope;
        
        super.visitStructDeclaration(ctx);
        
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
            System.out.println(firstOp);
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
        
        return ic;
    }

    @Override
    public Object visitUnaryExpr(DECAF2Parser.UnaryExprContext ctx) {
         return visit(ctx.getChild(0)); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object visitMultDivExpr(DECAF2Parser.MultDivExprContext ctx) {
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
        codigo.setRes(ctx.getChild(0).getChild(0).getText());
        
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
}
