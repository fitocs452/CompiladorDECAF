/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DECAF2.DECAF2BaseVisitor;
import DECAF2.DECAF2Parser;
import java.util.ArrayList;
import java.util.Stack;
import org.antlr.v4.runtime.misc.NotNull;
/**
 *
 * @author GustavoAdolfo
 */
public class TablesGenerator<T> extends DECAF2BaseVisitor<Object> {
    private SymbolTable tablaSimbolos = new SymbolTable();
    private MethodTable tablaMetodos = new MethodTable();
    private StructTable tablaEstructura = new StructTable();
    private Scope scopeActual;
    private ArrayList<MensajeLog> mensajes = new ArrayList();
    
    // Pila dinámica que tienen como objetivo almacenar los valores literales temporalmente
    private Stack literalStack = new Stack();
    
    public TablesGenerator() {}
    
    public TablesGenerator(DECAF2Parser.ProgramaContext tree) {
        
        this.visitPrograma(tree);
        Scope.ambitoActual = 0;
        verifyMainMethod();
    }
    
    @Override
    public T visitPrograma(@NotNull DECAF2Parser.ProgramaContext ctx) {
        System.out.println("Program: " + ctx.getText());
        scopeActual = new Scope();
        return (T)visitChildren(ctx);
    }
    
    /**************************   Declaraciones principales que pueden existir después de programa   ***********************************/
    
    //Override
    public T visitVarDeclaration(@NotNull DECAF2Parser.VarDeclarationContext ctx) {
        // Siempre tiene 3 hijos, tipo id ;
        // o 6 hijos, tipo id [ lenght ] ;
        String type = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        
        if (type.contains("struct")) {
            this.visit(ctx.getChild(0));
        }
        //System.out.println("Declaración de variable: " + ctx.getText());
        
        Type tipoDato = new Type(type);
        
        switch(ctx.getChildCount()) {
            // En caso de que sea una declaración de variable simple
            case 3:
                tipoDato.setIsSimple(true);
                break;
            // En caso de que sea una declaración de array
            case 6:
                if (Integer.valueOf(ctx.getChild(3).getText()) <= 0) {
                    String mensaje = "Error linea: " + ctx.getStart().getLine() + " Parámetro para declaración de array incorrecto";
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }
                tipoDato.setIsArray(true, Integer.valueOf(ctx.getChild(3).getText()));
                break;
        }
        
        Symbol simbolo = new Symbol();
        simbolo.setId(id);
        simbolo.setType(tipoDato);
        simbolo.setScope(scopeActual);
        
        tablaSimbolos.addSymbol(simbolo, scopeActual);
        
        return (T)simbolo;
    }
    
    @Override
    public T visitSimpleVarDeclaration(@NotNull DECAF2Parser.SimpleVarDeclarationContext ctx) {
        //this.visit(ctx.getChild(0));
        String type = ctx.getChild(0).getText();
        
        if (ctx.getChild(0).getText().contains("struct")) {
            Object typeStruct = this.visit(ctx.getChild(0));
            if (typeStruct instanceof Structure) {
                Structure strc = (Structure)typeStruct;
                type = strc.getId();
            }
            if (typeStruct instanceof String) {
                type = (String)typeStruct;
            }
            //type = (String)this.visit(ctx.getChild(0));
        }
        
        String id = ctx.getChild(1).getText();
        
        Type tipoDato = new Type(type);
        tipoDato.setIsSimple(true);

        if (this.findSymbolInScopes(id) != null) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Variable ya declarada";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return null;
        }
        
        Symbol simbolo = new Symbol();
        simbolo.setId(id);
        simbolo.setType(tipoDato);
        simbolo.setScope(scopeActual);
        
        tablaSimbolos.addSymbol(simbolo, scopeActual);
       
        return (T)simbolo;
    }
    
    @Override
    public T visitArrayVarDeclaration(@NotNull DECAF2Parser.ArrayVarDeclarationContext ctx) {
        String type = ctx.getChild(0).getText();
        
        if (ctx.getChild(0).getText().contains("struct")) {
            Object typeStruct = this.visit(ctx.getChild(0));
            if (typeStruct instanceof Structure) {
                Structure strc = (Structure)typeStruct;
                type = strc.getId();
            }
            if (typeStruct instanceof String) {
                type = (String)typeStruct;
            }
            //type = (String)this.visit(ctx.getChild(0));
        }
        String id = ctx.getChild(1).getText();
        
        Type tipoDato = new Type(type);
        
        if (this.findSymbolInScopes(id) != null) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Variable ya declarada";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return null;
        }
        
        if (Integer.valueOf(ctx.getChild(3).getText()) <= 0) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Parámetro para declaración de array incorrecto";
            this.mensajes.add(new MensajeLog(mensaje, true));
        }
        tipoDato.setIsArray(true, Integer.valueOf(ctx.getChild(3).getText()));
        
        Symbol simbolo = new Symbol();
        simbolo.setId(id);
        simbolo.setType(tipoDato);
        simbolo.setScope(scopeActual);
        
        tablaSimbolos.addSymbol(simbolo, scopeActual);
        
        return (T)simbolo;
    }
    
    @Override
    public T visitVarType(@NotNull DECAF2Parser.VarTypeContext ctx) {
        System.out.println(ctx.getText());
        if (ctx.getChild(0).getChildCount() > 1){
            String returnString = "";
            System.out.println("Context Var Type: " +  ctx.getText() + " cantHijos: " + ctx.getChildCount());
            /*for (int i = 0; i < ctx.getChildCount(); i++) {
                this.visit(ctx.getChild(i));
                returnString = ctx.getChild(i).getText() + " ";
            }*/
            
            return (T)this.visitChildren(ctx);
        }
        
        if (ctx.getText().contains("struct")) {
            if (this.visitChildren(ctx) == null) {
                String ctxSTR = ctx.getText();
                int indexOfStructSTR = ctxSTR.indexOf("struct") + 6;
                return (T)ctx.getText().substring(indexOfStructSTR);
            }
        }
        
        return (T)ctx.getText();
    }
    
    @Override
    public T visitStructDeclaration(@NotNull DECAF2Parser.StructDeclarationContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        String structName = ctx.getChild(1).getText();
        ArrayList<Symbol> members = new ArrayList();
        
        for (int i = 3; i < ctx.getChildCount(); i++) {
            Object var = this.visit(ctx.getChild(i));
            
            if (Symbol.class.isInstance(var)) {
                Symbol simbolo = (Symbol)var;
                members.add(simbolo);
            }
        }
        
        scopeActual = scopeActual.getAnterior();
        
        Structure estructura = new Structure(structName, scopeActual, members);
        tablaEstructura.addStructure(estructura);
        
        return (T)estructura;
    }

    @Override
    public T visitMethodDeclaration(@NotNull DECAF2Parser.MethodDeclarationContext ctx) {
        /**
         * void lol ( int a, int b, int x[1] ) {
         *      int c;
         * }
         */
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        String ret = ctx.getChild(0).getText();
        Type returnType = new Type(ret);
        returnType.setIsSimple(true);
        
        String id = ctx.getChild(1).getText();        

        //System.out.println("Metodo: " + ctx.getText());
        ArrayList<Symbol> parametros = new ArrayList();
        
        for (int i = 3; i < ctx.getChildCount(); i++) {
            Object var = this.visit(ctx.getChild(i));
            
            if (Symbol.class.isInstance(var)) {
                Symbol simbolo = (Symbol)var;
                
                if (simbolo.getType().isParam()) {
                    parametros.add(simbolo);
                }
            }
        }
        
        Method metodo = new Method(id, returnType, parametros);
        tablaMetodos.addMethod(metodo);
        
        scopeActual = scopeActual.getAnterior();
        return (T)new String();
        //return (T)visitChildren(ctx);
    }
    
    /****************************************************************************************************************/
    
    /**************************** IF, ELSE, WHILE *******************************************************************/
    /**
     * @param ctx
     * @return 
     */
    @Override
    public T visitIfS(@NotNull DECAF2Parser.IfSContext ctx) {
        
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (this.visit(ctx.getChild(i)) != null) {
                String tipoExp = (String)this.visit(ctx.getChild(i));
                if (!tipoExp.contains("bool")) {
                    String mensaje = "Error linea: " + ctx.getStart().getLine() + " Expresión no válida";
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }
            }
        }
        
        scopeActual = scopeActual.getAnterior();
        //return (T)visitChildren(ctx);
        return (T)new String();
    }
    
    @Override
    public T visitElseS(@NotNull DECAF2Parser.ElseSContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            this.visit(ctx.getChild(i));
        }
        
        scopeActual = scopeActual.getAnterior();
        return (T)new String();
    }
    
    @Override
    public T visitWhileS(@NotNull DECAF2Parser.WhileSContext ctx) {
        Scope nuevoScope = new Scope();
        scopeActual.addScopeChild(nuevoScope);
        nuevoScope.setAnterior(scopeActual);
        
        scopeActual = nuevoScope;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (this.visit(ctx.getChild(i)) != null) {
                String tipoExp = (String)this.visit(ctx.getChild(i));
                if (!tipoExp.contains("bool")) {
                    String mensaje = "Error linea: " + ctx.getStart().getLine() + " Expresión no válida";
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }
            }
        }
        
        scopeActual = scopeActual.getAnterior();
        
        return (T)new String();
    }
    
    @Override
    public T visitBlock(@NotNull DECAF2Parser.BlockContext ctx) {
        return (T)visitChildren(ctx);
    }
    
    /****************************************************************************************************************/
    @Override
    public T visitParameter(@NotNull DECAF2Parser.ParameterContext ctx) {
        //System.out.println("Parametro: " + ctx.getText());
        
        String type = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        
        Type tipoDato = new Type(type);
        
        switch(ctx.getChildCount()) {
            // En caso de que sea una declaración de variable simple
            case 2:
                tipoDato.setIsParam(true);
                tipoDato.setIsSimple(true);
                break;
            // En caso de que sea una declaración de array
            case 5:
                tipoDato.setIsParam(true);
                tipoDato.setIsArray(true, Integer.valueOf(ctx.getChild(3).getText()));
                break;
        }
        
        Symbol parametro = new Symbol();
        parametro.setId(id);
        parametro.setType(tipoDato);
        parametro.setScope(scopeActual);
        
        return (T)parametro;
    }

    @Override
    public T visitAssign(@NotNull DECAF2Parser.AssignContext ctx) {
        String id = ctx.getChild(0).getText();
        String cuerpo = ctx.getChild(2).getText();
        
        String nombreVariable = id;
        if (id.contains("[")) {
            nombreVariable = id.substring(0, id.indexOf("["));
        }    
        
        Symbol simbolo = this.findSymbolInScopes(nombreVariable);  

        if (simbolo == null) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " No existe variable";
            this.mensajes.add(new MensajeLog(mensaje, true));
            
            return (T)"Error";
        }
        
        if (simbolo.getType().isArray() && !id.contains("[")) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Debe tener índice";
            this.mensajes.add(new MensajeLog(mensaje, true));
            
            return (T)"Error";
        }
         
        String tipoExpresionAsignar = (String)this.visit(ctx.getChild(2));
        
        String nombreTipoSimbolo = simbolo.getType().getTypeName();
        if (nombreTipoSimbolo.contains("[")) {
            nombreTipoSimbolo = nombreTipoSimbolo.substring(0, nombreTipoSimbolo.indexOf("["));
        }
        
        if (tipoExpresionAsignar.contains("literal_T")) {
            //System.out.println("Sí es un literal " + tipoExpresionAsignar);
            if (tipoExpresionAsignar.contains(nombreTipoSimbolo)) {
                //System.out.println("Sí contiene eso: TEA " + tipoExpresionAsignar + " NTS: " + nombreTipoSimbolo);
                String mensaje = "En linea: " + ctx.getStart().getLine() + " Tipo de dato válido";
                this.mensajes.add(new MensajeLog(mensaje, false));
            } else {
                String mensaje = "Error linea: " + ctx.getStart().getLine() + " Tipo de dato no válido";
                this.mensajes.add(new MensajeLog(mensaje, true));
            }
        } else {
            //System.out.println("No es un literal " + tipoExpresionAsignar + " Entonces, es método, variable, estructura o array");
            //System.out.println("---------------- " + tipoExpresionAsignar);
            if (!tipoExpresionAsignar.contains("error")) {
                Symbol simboloX = this.findSymbolInScopes(tipoExpresionAsignar);

                if (simboloX.getType().getTypeName().contains(simbolo.getType().getTypeName())) {
                    //System.out.println("Es correcta la asignación de tipo de variable");
                    String mensaje = ("En linea: " + ctx.getStart().getLine() + " Tipo de dato compatible");
                    this.mensajes.add(new MensajeLog(mensaje, false));
                } else {
                    //System.out.println("Es incorrecta la asignación por los tipos");
                    String mensaje = ("Error linea: " + ctx.getStart().getLine() + " Tipo de datos no compatibles");
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }
            }
        }

        return (T)this.visitChildren(ctx);
    }
    
    @Override
    public T visitReturnS(@NotNull DECAF2Parser.ReturnSContext ctx) {
        //System.out.println("LOL: " + ctx.getParent().getParent().getParent().getText());
        if (ctx.getParent().getParent().getParent().getChild(0).getChild(0) == null) {
            return null;
        }
        String tipoDatoReturn = (String)this.visit(ctx.getChild(1));
        String tipoDatoMetodo = ctx.getParent().getParent().getParent().getChild(0).getChild(0).getText();
        String nombreMetodo = ctx.getParent().getParent().getParent().getChild(1).getText();

        Symbol simboloReturnVariable = this.findSymbolInScopes(tipoDatoReturn);
        
        //System.out.println("Tipo dato return: " + tipoDatoReturn);
        
        if (simboloReturnVariable == null) {
            if (tipoDatoReturn.equals("int_literal_T")) {
                tipoDatoReturn = "int";
            } else if (tipoDatoReturn.equals("char_literal_T")) {
                tipoDatoReturn = "char";
            } else if (tipoDatoReturn.equals("boolean_literal_T")) {
                tipoDatoReturn = "boolean";
            } else {
                tipoDatoReturn = "void";
            }
            
        } else {
            tipoDatoReturn = simboloReturnVariable.getType().getTypeName();
        }
        
        //System.out.println("Datos: " + tipoDatoReturn + " " + tipoDatoMetodo + " " + nombreMetodo);
        
        /*Method metodo = findMethod(nombreMetodo);
        if (metodo == null) {
            System.out.println("No existe método con nombre: " + nombreMetodo);
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Método: " + nombreMetodo + " No Existe!!";
            this.mensajes.add(new MensajeLog(mensaje, true));
        }*/
        if (tipoDatoMetodo.contains(tipoDatoReturn)) {
            //System.out.println("Es correcto el return del método");    
            String mensaje = "En linea: " + ctx.getStart().getLine() + " Método: " + nombreMetodo + " tiene return correcto";
            this.mensajes.add(new MensajeLog(mensaje, false));
        } else {
            //System.out.println("Es incorrecto el return del método");
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Método: " + nombreMetodo + " tiene return incorrecto";
            this.mensajes.add(new MensajeLog(mensaje, true));
        }
        
        return (T)visitChildren(ctx);
    }
    
    @Override
    public T visitMethodCall(@NotNull DECAF2Parser.MethodCallContext ctx) {
        String nombreMetodo = ctx.getChild(0).getText();
        Method metodo = findMethod(nombreMetodo);
        
        if (metodo == null) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Método: " + nombreMetodo + " No existe";
            this.mensajes.add(new MensajeLog(mensaje, true));
            
            return (T)"error_literal";
        }
        
        ArrayList<Symbol> parametros = metodo.getParameters();
        
        int contParametros = 0;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (this.visit(ctx.getChild(i)) != null) {
                contParametros++;
            }
        }
        
        if (contParametros != parametros.size()) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Número de parametros incorrecto";
            this.mensajes.add(new MensajeLog(mensaje, true));
        } else {
            String mensaje = "En linea: " + ctx.getStart().getLine() + " Número de parámetros correcto";
            this.mensajes.add(new MensajeLog(mensaje, false));
        }
        
        int parametroActual = 0;
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (this.visit(ctx.getChild(i)) == null) {
                continue;
            }
            String nombreVar = (String)this.visit(ctx.getChild(i));
            /*if (nombreVar.contains("int") || nombreVar.contains("bool") || nombreVar.contains("char")) {
                continue;
            }*/
            
            Symbol param = findSymbolInScopes(nombreVar);
            
            Symbol parametroNecesarioMetodo = parametros.get(parametroActual);
            String tipoParametroActual = parametroNecesarioMetodo.getType().getTypeName();
            String tipoParametroRecibido = new String();
            
            if (param != null) {
                tipoParametroRecibido = param.getType().getTypeName();
                nombreVar = param.getId();
            } else {
                tipoParametroRecibido = nombreVar;
            }
            
            if (tipoParametroRecibido.equals("int_literal_T")) {
                tipoParametroRecibido = "int";
            } else if (tipoParametroRecibido.equals("char_literal_T")) {
                tipoParametroRecibido = "char";
            } else if (tipoParametroRecibido.equals("bool_literal_T")) {
                tipoParametroRecibido = "bool";
            }
                        
            if (tipoParametroActual.contains(tipoParametroRecibido)) {
                String mensaje = "En linea: " + ctx.getStart().getLine() + " Parametro: " + nombreVar + " Es correcto";
                this.mensajes.add(new MensajeLog(mensaje, false));
            } else {
                String mensaje = "Error linea: " + ctx.getStart().getLine() + " Parametro: " + nombreVar + " Es incorrecto";
                this.mensajes.add(new MensajeLog(mensaje, true));
            }
            
            parametroActual++;
            
            if (parametroActual == parametros.size()) {              
                break;
            }
        }
        
        return (T)(metodo.getRet().getTypeName() + "_literal_T");
    }
    
    @Override
    public T visitArrayVariable(@NotNull DECAF2Parser.ArrayVariableContext ctx) {
        String nombreVar = (String)ctx.getChild(0).getText();
        String param = (String)this.visit(ctx.getChild(2));
        
        if (!param.contains("int") || param.isEmpty()) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Índice: " + ctx.getChild(2).getText() + " (no es entero | no existe)";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return (T)visitChildren(ctx);
        }
        
        Symbol variable = this.findSymbolInScopes(nombreVar);
        
        if (variable == null) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Variable: " + nombreVar + " No existe";
            this.mensajes.add(new MensajeLog(mensaje, true));
        }
        
        if (variable != null) {
            if (!variable.getType().isArray()) {
                String mensaje = "Error linea: " + ctx.getStart().getLine() + " Variable: " + nombreVar + " No es de tipo array";
                this.mensajes.add(new MensajeLog(mensaje, true));
            } else {
                int indiceLlamado = Integer.parseInt((String)literalStack.pop());
                if (indiceLlamado < 0) {
                    String mensaje = "Error linea: " + ctx.getStart().getLine() + " Parametro: " + indiceLlamado + " Debe ser mayor que cero";
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }

                if (indiceLlamado > (variable.getType().getArrayLenght() - 1)) {
                    String mensaje = "Error linea: " + ctx.getStart().getLine() + " Parametro: " + indiceLlamado + " Está fuera de rango";
                    this.mensajes.add(new MensajeLog(mensaje, true));
                }
            }
        }
        return (T)visitChildren(ctx);
    }
    
    // Condiciones anidadas con OR
    @Override
    public T visitOrConditionExpr(@NotNull DECAF2Parser.OrConditionExprContext ctx) {
        return (T)visitChildren(ctx);
    }
    
    // Condiciones anidadas con AND
    @Override
    public T visitAndConditionExpr(@NotNull DECAF2Parser.AndConditionExprContext ctx) {
        return (T)visitChildren(ctx);
    }
    
    // Igualdad o si es distinto
    @Override
    public T visitEqIneqExpr(@NotNull DECAF2Parser.EqIneqExprContext ctx) {
        int cant = ctx.getChildCount();
        
        if (cant>1){
            return (T)"boolean_literal_T";
        }
        return (T)this.visit(ctx.getChild(0));
    }
    
    @Override
    public T visitSimpleRelationExpr(@NotNull DECAF2Parser.SimpleRelationExprContext ctx) {
        return (T)this.visit(ctx.getChild(0));
    }
    
    @Override
    public T visitSimpleAddExpr(@NotNull DECAF2Parser.SimpleAddExprContext ctx) {
        return (T)this.visit(ctx.getChild(0));
    }
    
    // Mayor, menor, mayor o igual, menor o igual
    @Override
    public T visitConditionalExpr(@NotNull DECAF2Parser.ConditionalExprContext ctx) {
        return (T)"boolean";
    }
    
    // Suma y resta
    @Override
    public T visitAddDiffExpr(@NotNull DECAF2Parser.AddDiffExprContext ctx) {
        String firstOpType = (String)this.visit(ctx.getChild(0));
        String secondOpType = (String)this.visit(ctx.getChild(2));
        
        String firstOp = (String)(ctx.getChild(0).getChild(0).getText());
        String secondOp = (String)(ctx.getChild(2).getChild(0).getText());
        
        if (!firstOpType.contains("literal_T")){
            Symbol firstSymbol = this.findSymbolInScopes(firstOp);
            if (firstSymbol != null)
                firstOpType = firstSymbol.getType().getTypeName();
            else{
                for (int j = 0; j < ctx.getChildCount(); j++) {
                    visit(ctx.getChild(j));
                }
            }
        }
        
        if (!secondOpType.contains("literal_T")) {
            Symbol secondSymbol = this.findSymbolInScopes(secondOpType);
            secondOpType = secondSymbol.getType().getTypeName();
        }
        
        if (!firstOpType.contains("int")) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Valor: " + firstOp + " No es un número entero";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return (T)"error_literal";
        }
        if(!secondOpType.contains("int")){
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Valor: " + secondOp + " No es un número entero";
            this.mensajes.add(new MensajeLog(mensaje, true));
             return (T)"error_literal";
        }
    
        return (T)"int_literal_T";
    }
    
    // Multiplicación y división
    @Override public T visitMultDivExpr(@NotNull DECAF2Parser.MultDivExprContext ctx) {
        String firstOpType = (String)this.visit(ctx.getChild(0));
        String secondOpType = (String)this.visit(ctx.getChild(2));
        
        String firstOp = (String)(ctx.getChild(0).getChild(0).getText());
        String secondOp = (String)(ctx.getChild(2).getChild(0).getText());
        
        if (!firstOpType.contains("literal_T")){
            Symbol firstSymbol = this.findSymbolInScopes(firstOp);
            if (firstSymbol != null)
                firstOpType = firstSymbol.getType().getTypeName();
            else{
                for (int j = 0; j < ctx.getChildCount(); j++) {
                    visit(ctx.getChild(j));
                }
            }
        }
        
        if (!secondOpType.contains("literal_T")) {
            Symbol secondSymbol = this.findSymbolInScopes(secondOpType);
            secondOpType = secondSymbol.getType().getTypeName();
        }
        
        if (!firstOpType.contains("int")) {
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Valor: " + firstOp + " No es un número entero";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return (T)"error_literal_T";
        }
        if(!secondOpType.contains("int")){
            String mensaje = "Error linea: " + ctx.getStart().getLine() + " Valor: " + secondOp + " No es un número entero";
            this.mensajes.add(new MensajeLog(mensaje, true));
            return (T)"error_literal_T";
        }
    
        return (T)"int_literal_T";
    }
    
    @Override public T visitStatement(@NotNull DECAF2Parser.StatementContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            this.visit(ctx.getChild(i));
        }
        return (T)"";
    }
    
    public SymbolTable getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(SymbolTable tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public MethodTable getTablaMetodos() {
        return tablaMetodos;
    }

    public void setTablaMetodos(MethodTable tablaMetodos) {
        this.tablaMetodos = tablaMetodos;
    }

    public StructTable getTablaEstructura() {
        return tablaEstructura;
    }

    public void setTablaEstructura(StructTable tablaEstructura) {
        this.tablaEstructura = tablaEstructura;
    }
    
    @Override
    public T visitInt_literal(@NotNull DECAF2Parser.Int_literalContext ctx) {
        literalStack.push(ctx.getChild(0).getText());
        return (T)"int_literal_T";
    }

    @Override
    public T visitChar_literal(@NotNull DECAF2Parser.Char_literalContext ctx) {
        return (T)"char_literal_T";
    }
    
    @Override
    public T visitBool_literal(@NotNull DECAF2Parser.Bool_literalContext ctx) {
        return (T)"boolean_literal_T";
    }
    
    @Override
    public T visitLocation(@NotNull DECAF2Parser.LocationContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            this.visit(ctx.getChild(i));
        }
        return (T)ctx.getChild(0).getText();
    }

    public Symbol findSymbolInScopes(String id) {
        Scope actual = this.scopeActual;
        
        while (actual != null) {
            for (Symbol s: this.tablaSimbolos.getAllSymbolInScope(actual)) {
                if (s.getId().equals(id)) {
                    return s;
                }
            }
            actual = actual.getAnterior();
        }
        
        return null;
    }
    
    public Symbol findSymbolInScopes(String id, Scope buscarAmbito) {
        for (Symbol s: this.tablaSimbolos.getAllSymbolInScope(buscarAmbito)) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        
        return null;
    }
    
    public Method findMethod(String id) {
        for (Method m: this.getTablaMetodos().getAllMethods()) {
            if (m.getName().equals(id)) {
                return m;
            }
        }
        
        return null;
    }

    public ArrayList<MensajeLog> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<MensajeLog> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void verifyMainMethod() {        
        Method mainMethod = this.findMethod("main");
        
        if (mainMethod == null) {
            String mensaje = "Error:  No tiene método main()";
            this.mensajes.add(new MensajeLog(mensaje, true));
        } else {
            if (!mainMethod.getParameters().isEmpty()) {
                String mensaje = "Error:  El método main no debe tener parámetros";
                this.mensajes.add(new MensajeLog(mensaje, true));
            }
        }
    }
}
