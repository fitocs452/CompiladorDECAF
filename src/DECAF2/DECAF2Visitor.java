// Generated from C:\Users\GustavoAdolfo\Documents\NetBeansProjects\DECAF_GRAMMAR\src\DECAF2\DECAF2.g4 by ANTLR 4.4
package DECAF2;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DECAF2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DECAF2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(@NotNull DECAF2Parser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDivExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpr(@NotNull DECAF2Parser.MultDivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull DECAF2Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqIneqExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqIneqExpr(@NotNull DECAF2Parser.EqIneqExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#mult_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_op(@NotNull DECAF2Parser.Mult_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleVarDeclaration(@NotNull DECAF2Parser.SimpleVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(@NotNull DECAF2Parser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleUnaryExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleUnaryExpr(@NotNull DECAF2Parser.SimpleUnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#add_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_op(@NotNull DECAF2Parser.Add_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(@NotNull DECAF2Parser.Bool_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrConditionExpr}
	 * labeled alternative in {@link DECAF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrConditionExpr(@NotNull DECAF2Parser.OrConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(@NotNull DECAF2Parser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleAddExpr}
	 * labeled alternative in {@link DECAF2Parser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAddExpr(@NotNull DECAF2Parser.SimpleAddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull DECAF2Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(@NotNull DECAF2Parser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#arrayVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariable(@NotNull DECAF2Parser.ArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(@NotNull DECAF2Parser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(@NotNull DECAF2Parser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(@NotNull DECAF2Parser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(@NotNull DECAF2Parser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull DECAF2Parser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#ifS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfS(@NotNull DECAF2Parser.IfSContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull DECAF2Parser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull DECAF2Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull DECAF2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#returnS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnS(@NotNull DECAF2Parser.ReturnSContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#exp1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp1(@NotNull DECAF2Parser.Exp1Context ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull DECAF2Parser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#structLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructLocation(@NotNull DECAF2Parser.StructLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull DECAF2Parser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(@NotNull DECAF2Parser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleAndExpr}
	 * labeled alternative in {@link DECAF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAndExpr(@NotNull DECAF2Parser.SimpleAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndConditionExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndConditionExpr(@NotNull DECAF2Parser.AndConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleMultExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleMultExpr(@NotNull DECAF2Parser.SimpleMultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#expressionNueva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNueva(@NotNull DECAF2Parser.ExpressionNuevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#simpleVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleVariable(@NotNull DECAF2Parser.SimpleVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpr}
	 * labeled alternative in {@link DECAF2Parser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpr(@NotNull DECAF2Parser.ConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull DECAF2Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVarDeclaration(@NotNull DECAF2Parser.ArrayVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#simpleLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLocation(@NotNull DECAF2Parser.SimpleLocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleRelationExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleRelationExpr(@NotNull DECAF2Parser.SimpleRelationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddDiffExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddDiffExpr(@NotNull DECAF2Parser.AddDiffExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleEqExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleEqExpr(@NotNull DECAF2Parser.SimpleEqExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#elseS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseS(@NotNull DECAF2Parser.ElseSContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#whileS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileS(@NotNull DECAF2Parser.WhileSContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(@NotNull DECAF2Parser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull DECAF2Parser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link DECAF2Parser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull DECAF2Parser.MethodCallContext ctx);
}