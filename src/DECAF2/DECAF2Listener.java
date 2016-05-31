// Generated from /home/adolfo/Universidad/Compiladores/CompiladorDECAF/src/DECAF2/DECAF2.g4 by ANTLR 4.4
package DECAF2;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DECAF2Parser}.
 */
public interface DECAF2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(@NotNull DECAF2Parser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(@NotNull DECAF2Parser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpr(@NotNull DECAF2Parser.MultDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpr(@NotNull DECAF2Parser.MultDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull DECAF2Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull DECAF2Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqIneqExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqIneqExpr(@NotNull DECAF2Parser.EqIneqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqIneqExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqIneqExpr(@NotNull DECAF2Parser.EqIneqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#mult_op}.
	 * @param ctx the parse tree
	 */
	void enterMult_op(@NotNull DECAF2Parser.Mult_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#mult_op}.
	 * @param ctx the parse tree
	 */
	void exitMult_op(@NotNull DECAF2Parser.Mult_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleVarDeclaration(@NotNull DECAF2Parser.SimpleVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleVarDeclaration(@NotNull DECAF2Parser.SimpleVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(@NotNull DECAF2Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(@NotNull DECAF2Parser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleUnaryExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleUnaryExpr(@NotNull DECAF2Parser.SimpleUnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleUnaryExpr}
	 * labeled alternative in {@link DECAF2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleUnaryExpr(@NotNull DECAF2Parser.SimpleUnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#add_op}.
	 * @param ctx the parse tree
	 */
	void enterAdd_op(@NotNull DECAF2Parser.Add_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#add_op}.
	 * @param ctx the parse tree
	 */
	void exitAdd_op(@NotNull DECAF2Parser.Add_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(@NotNull DECAF2Parser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(@NotNull DECAF2Parser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(@NotNull DECAF2Parser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(@NotNull DECAF2Parser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull DECAF2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull DECAF2Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(@NotNull DECAF2Parser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(@NotNull DECAF2Parser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariable(@NotNull DECAF2Parser.ArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariable(@NotNull DECAF2Parser.ArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(@NotNull DECAF2Parser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(@NotNull DECAF2Parser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(@NotNull DECAF2Parser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(@NotNull DECAF2Parser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(@NotNull DECAF2Parser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(@NotNull DECAF2Parser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(@NotNull DECAF2Parser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(@NotNull DECAF2Parser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull DECAF2Parser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull DECAF2Parser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#ifS}.
	 * @param ctx the parse tree
	 */
	void enterIfS(@NotNull DECAF2Parser.IfSContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#ifS}.
	 * @param ctx the parse tree
	 */
	void exitIfS(@NotNull DECAF2Parser.IfSContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull DECAF2Parser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull DECAF2Parser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull DECAF2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull DECAF2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull DECAF2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull DECAF2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#returnS}.
	 * @param ctx the parse tree
	 */
	void enterReturnS(@NotNull DECAF2Parser.ReturnSContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#returnS}.
	 * @param ctx the parse tree
	 */
	void exitReturnS(@NotNull DECAF2Parser.ReturnSContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#exp1}.
	 * @param ctx the parse tree
	 */
	void enterExp1(@NotNull DECAF2Parser.Exp1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#exp1}.
	 * @param ctx the parse tree
	 */
	void exitExp1(@NotNull DECAF2Parser.Exp1Context ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull DECAF2Parser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull DECAF2Parser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#structLocation}.
	 * @param ctx the parse tree
	 */
	void enterStructLocation(@NotNull DECAF2Parser.StructLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#structLocation}.
	 * @param ctx the parse tree
	 */
	void exitStructLocation(@NotNull DECAF2Parser.StructLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpr(@NotNull DECAF2Parser.RelationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpr(@NotNull DECAF2Parser.RelationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull DECAF2Parser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull DECAF2Parser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(@NotNull DECAF2Parser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(@NotNull DECAF2Parser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndConditionExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndConditionExpr(@NotNull DECAF2Parser.AndConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndConditionExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndConditionExpr(@NotNull DECAF2Parser.AndConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleMultExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleMultExpr(@NotNull DECAF2Parser.SimpleMultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleMultExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleMultExpr(@NotNull DECAF2Parser.SimpleMultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#expressionNueva}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNueva(@NotNull DECAF2Parser.ExpressionNuevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#expressionNueva}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNueva(@NotNull DECAF2Parser.ExpressionNuevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull DECAF2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull DECAF2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#simpleVariable}.
	 * @param ctx the parse tree
	 */
	void enterSimpleVariable(@NotNull DECAF2Parser.SimpleVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#simpleVariable}.
	 * @param ctx the parse tree
	 */
	void exitSimpleVariable(@NotNull DECAF2Parser.SimpleVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull DECAF2Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull DECAF2Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayVarDeclaration(@NotNull DECAF2Parser.ArrayVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVarDeclaration}
	 * labeled alternative in {@link DECAF2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayVarDeclaration(@NotNull DECAF2Parser.ArrayVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#simpleLocation}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLocation(@NotNull DECAF2Parser.SimpleLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#simpleLocation}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLocation(@NotNull DECAF2Parser.SimpleLocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleRelationExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleRelationExpr(@NotNull DECAF2Parser.SimpleRelationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleRelationExpr}
	 * labeled alternative in {@link DECAF2Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleRelationExpr(@NotNull DECAF2Parser.SimpleRelationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddDiffExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddDiffExpr(@NotNull DECAF2Parser.AddDiffExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddDiffExpr}
	 * labeled alternative in {@link DECAF2Parser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddDiffExpr(@NotNull DECAF2Parser.AddDiffExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleEqExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleEqExpr(@NotNull DECAF2Parser.SimpleEqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleEqExpr}
	 * labeled alternative in {@link DECAF2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleEqExpr(@NotNull DECAF2Parser.SimpleEqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#elseS}.
	 * @param ctx the parse tree
	 */
	void enterElseS(@NotNull DECAF2Parser.ElseSContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#elseS}.
	 * @param ctx the parse tree
	 */
	void exitElseS(@NotNull DECAF2Parser.ElseSContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#whileS}.
	 * @param ctx the parse tree
	 */
	void enterWhileS(@NotNull DECAF2Parser.WhileSContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#whileS}.
	 * @param ctx the parse tree
	 */
	void exitWhileS(@NotNull DECAF2Parser.WhileSContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(@NotNull DECAF2Parser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(@NotNull DECAF2Parser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull DECAF2Parser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull DECAF2Parser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DECAF2Parser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull DECAF2Parser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DECAF2Parser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull DECAF2Parser.MethodCallContext ctx);
}