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
    
    private final int BOOL_OFFSET = 4;
    private final int INT_OFFSET = 4;
    private final int CHAR_OFFSET = 1;

    public IntermediateCodeGenerator(TablesGenerator tablas, DECAF2Parser.ProgramaContext tree) {
        
        System.out.println("Generar código intermedio ---------------------------");
        this.tablas = tablas;
        
        tablaCodigo = new IntermediateCodeTable(tablas);
        stack = new ArrayList();
        scopeActual = new Scope();
        
        booleanDataTypes = new ArrayList();
        booleanDataTypes.add("true");
        booleanDataTypes.add("false");
        
        this.visitPrograma(tree);
        Scope.ambitoActual = 0;
    }
    
    @Override
    public T visitPrograma(@NotNull DECAF2Parser.ProgramaContext ctx) {
        return (T)super.visitPrograma(ctx);
    }
    
    @Override
    public Object visitArrayVarDeclaration(DECAF2Parser.ArrayVarDeclarationContext ctx) {
        System.out.println("Var declaration array");
        String tipo = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        int lenght = Integer.parseInt(ctx.getChild(3).getText());
        
        IntermediateCode codigo = new IntermediateCode();
        if (scopeActual.getName() == 0) {
           
            codigo.setLabel(ctx.getChild(1).getText() + "_global");
            codigo.setIsGlobal(true);
            tablaCodigo.addCodigo(codigo);
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
        System.out.println("Var declaration simple");
        IntermediateCode codigo = new IntermediateCode();
        
        if (scopeActual.getName() == 0) {
            codigo.setLabel(ctx.getChild(1).getText() + "_global");
            codigo.setIsGlobal(true);
            tablaCodigo.addCodigo(codigo);
            return super.visitSimpleVarDeclaration(ctx);
        }
        
        String tipo = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        
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
        String result = ((String)visit(ctx.getChild(0)));
        IntermediateCode codigo = new IntermediateCode();
        System.out.println("Result: " + result + " of visit: " + ctx.getChild(0).getText());
        if (result.contains("[")) {
            isSimpleLocation = false;
        }
        
        if (isSimpleLocation) {
            Symbol simbolo = tablaCodigo.findSymbolInGlobalScope(result, scopeActual);

            System.out.println("Simbolo a buscar: " + result  + " encontrado: " + simbolo);
            if (simbolo != null) {
                IntermediateCode code = this.tablaCodigo.searchCodeGlobal(result);
                result = code.getLabel();

            } else {
               result = "stack[" + this.findPosInStackById(result) + "]";
            }
        
            /*
            Se uitlizarán variables que representan las direccions (dir1, dir2)
            */
            String dir1;
            T eval = (T)visit(ctx.getChild(2));

            if (eval instanceof IntermediateCode ) {
                dir1 = ((IntermediateCode)eval).getRes();
            } else if (eval instanceof ArrayList) {
                if (((ArrayList)eval).get(0) instanceof String) {
                    dir1 = ((String)((ArrayList)eval).get(0));
                } else {
                    dir1 = ((IntermediateCode)((ArrayList)eval).get(0)).getRes();
                }
            } else {
                dir1 = (String)eval;
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
        
        return super.visitAssign(ctx);
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
                operators.push(((IntermediateCode)value).getRes());
            }
        }
        
        if (countOperators > 1) {
            firstOpTmp = operators.pop();
            firstOp= firstOpTmp;
        }
        if (firstOpTmp.isEmpty()){
            firstOp = (String)this.visit(ctx.getChild(0));
        }
        
        if (countOperators >= 2){
            secondOpTmp = operators.pop();
            secondOp= secondOpTmp;
        }
        if (firstOpTmp.isEmpty()){
            secondOp = (String)this.visit(ctx.getChild(2));
        }
        
        IntermediateCode ic = new IntermediateCode(
                firstOp,
                secondOp,
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
                countOperators++;
                operators.push(((IntermediateCode)value).getRes());
            }
        }
        
        if (countOperators > 1) {
            firstOpTmp = operators.pop();
            firstOp= firstOpTmp;
        }
        if (firstOpTmp.isEmpty()){
            firstOp = (String)this.visit(ctx.getChild(0));
        }
        
        if (countOperators >= 2){
            secondOpTmp = operators.pop();
            secondOp= secondOpTmp;
        }
        if (firstOpTmp.isEmpty()){
            secondOp = (String)this.visit(ctx.getChild(2));
        }
        
        IntermediateCode ic = new IntermediateCode(
                firstOp,
                secondOp,
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
    
}
