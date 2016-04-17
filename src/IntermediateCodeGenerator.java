import DECAF2.DECAF2BaseVisitor;
import DECAF2.DECAF2Parser;
import java.util.ArrayList;
import org.antlr.v4.runtime.misc.NotNull;

public class IntermediateCodeGenerator<T> extends DECAF2BaseVisitor<Object> {
    
    private IntermediateCodeTable tablaCodigo;
    private TablesGenerator tablas;
    private Scope scopeActual;
    private ArrayList<StackPointer> stack;
    
    private final int BOOL_OFFSET = 4;
    private final int INT_OFFSET = 4;
    private final int CHAR_OFFSET = 1;

    public IntermediateCodeGenerator(TablesGenerator tablas, DECAF2Parser.ProgramaContext tree) {
        
        System.out.println("Generar código intermedio ---------------------------");
        this.tablas = tablas;
        
        tablaCodigo = new IntermediateCodeTable(tablas);
        stack = new ArrayList();
        scopeActual = new Scope();
        
        this.visitPrograma(tree);
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
        Symbol simbolo = tablaCodigo.findSymbolInGlobalScope(result, scopeActual);
        
        if (simbolo != null) {
            IntermediateCode code = this.tablaCodigo.searchCodeGlobal(result);
            result = code.getLabel();
           
        } else {
           result = "stack[" + this.findPosInStackById(result) + "]";
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
        return super.visitAddDiffExpr(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMultDivExpr(DECAF2Parser.MultDivExprContext ctx) {
        return super.visitMultDivExpr(ctx); //To change body of generated methods, choose Tools | Templates.
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
    
   public int findPosInStackById(String eval){
       for(StackPointer sp: this.stack){
           if (sp.getId().equals(eval)) {
               return sp.getPos();
           }
       }
       return -1;
   }
}
