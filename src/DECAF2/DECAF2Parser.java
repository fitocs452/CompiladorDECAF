// Generated from C:\Users\GustavoAdolfo\Documents\NetBeansProjects\DECAF_GRAMMAR\src\DECAF2\DECAF2.g4 by ANTLR 4.4
package DECAF2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DECAF2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, CLASSX=22, STRUCTX=23, TRUEX=24, 
		FALSEX=25, VOIDX=26, IFX=27, ELSEX=28, WHILEX=29, RETURNX=30, INTX=31, 
		CHARX=32, BOOLEANX=33, IDX=34, NUMX=35, CHARY=36, SPACEX=37, COMMENTX=38, 
		COMAX=39, WS=40, AND=41, OR=42;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'>='", "'['", "';'", "'{'", "'=='", "'<'", 
		"'='", "']'", "'}'", "'>'", "'<='", "'!'", "'%'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'.'", "'class'", "'struct'", "'true'", "'false'", "'void'", 
		"'if'", "'else'", "'while'", "'return'", "'int'", "'char'", "'boolean'", 
		"IDX", "NUMX", "CHARY", "SPACEX", "COMMENTX", "','", "WS", "'&&'", "'||'"
	};
	public static final int
		RULE_programa = 0, RULE_declaration = 1, RULE_varDeclaration = 2, RULE_structDeclaration = 3, 
		RULE_varType = 4, RULE_methodDeclaration = 5, RULE_methodType = 6, RULE_parameter = 7, 
		RULE_parameterType = 8, RULE_block = 9, RULE_statement = 10, RULE_assign = 11, 
		RULE_ifS = 12, RULE_elseS = 13, RULE_returnS = 14, RULE_whileS = 15, RULE_location = 16, 
		RULE_structLocation = 17, RULE_simpleLocation = 18, RULE_simpleVariable = 19, 
		RULE_arrayVariable = 20, RULE_exp1 = 21, RULE_expressionNueva = 22, RULE_expression = 23, 
		RULE_andExpr = 24, RULE_eqExpr = 25, RULE_relationExpr = 26, RULE_addExpr = 27, 
		RULE_multExpr = 28, RULE_unaryExpr = 29, RULE_value = 30, RULE_methodCall = 31, 
		RULE_arg = 32, RULE_add_op = 33, RULE_mult_op = 34, RULE_rel_op = 35, 
		RULE_eq_op = 36, RULE_literal = 37, RULE_int_literal = 38, RULE_char_literal = 39, 
		RULE_bool_literal = 40;
	public static final String[] ruleNames = {
		"programa", "declaration", "varDeclaration", "structDeclaration", "varType", 
		"methodDeclaration", "methodType", "parameter", "parameterType", "block", 
		"statement", "assign", "ifS", "elseS", "returnS", "whileS", "location", 
		"structLocation", "simpleLocation", "simpleVariable", "arrayVariable", 
		"exp1", "expressionNueva", "expression", "andExpr", "eqExpr", "relationExpr", 
		"addExpr", "multExpr", "unaryExpr", "value", "methodCall", "arg", "add_op", 
		"mult_op", "rel_op", "eq_op", "literal", "int_literal", "char_literal", 
		"bool_literal"
	};

	@Override
	public String getGrammarFileName() { return "DECAF2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DECAF2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public TerminalNode CLASSX() { return getToken(DECAF2Parser.CLASSX, 0); }
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(CLASSX);
			setState(83); match(IDX);
			setState(84); match(T__15);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRUCTX) | (1L << VOIDX) | (1L << INTX) | (1L << CHARX) | (1L << BOOLEANX))) != 0)) {
				{
				{
				setState(85); declaration();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); structDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); varDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); methodDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayVarDeclarationContext extends VarDeclarationContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public TerminalNode NUMX() { return getToken(DECAF2Parser.NUMX, 0); }
		public ArrayVarDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterArrayVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitArrayVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitArrayVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleVarDeclarationContext extends VarDeclarationContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public SimpleVarDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDeclaration);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SimpleVarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98); varType();
				setState(99); match(IDX);
				setState(100); match(T__16);
				}
				break;
			case 2:
				_localctx = new ArrayVarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102); varType();
				setState(103); match(IDX);
				setState(104); match(T__17);
				setState(105); match(NUMX);
				setState(106); match(T__11);
				setState(107); match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public TerminalNode STRUCTX() { return getToken(DECAF2Parser.STRUCTX, 0); }
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(STRUCTX);
			setState(112); match(IDX);
			setState(113); match(T__15);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRUCTX) | (1L << VOIDX) | (1L << INTX) | (1L << CHARX) | (1L << BOOLEANX))) != 0)) {
				{
				{
				setState(114); varDeclaration();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode CHARX() { return getToken(DECAF2Parser.CHARX, 0); }
		public TerminalNode INTX() { return getToken(DECAF2Parser.INTX, 0); }
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public TerminalNode BOOLEANX() { return getToken(DECAF2Parser.BOOLEANX, 0); }
		public TerminalNode STRUCTX() { return getToken(DECAF2Parser.STRUCTX, 0); }
		public TerminalNode VOIDX() { return getToken(DECAF2Parser.VOIDX, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varType);
		try {
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); match(INTX);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); match(CHARX);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); match(BOOLEANX);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125); match(STRUCTX);
				setState(126); match(IDX);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127); structDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128); match(VOIDX);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public List<TerminalNode> COMAX() { return getTokens(DECAF2Parser.COMAX); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode COMAX(int i) {
			return getToken(DECAF2Parser.COMAX, i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); methodType();
			setState(132); match(IDX);
			setState(133); match(T__5);
			setState(142);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTX) | (1L << CHARX) | (1L << BOOLEANX))) != 0)) {
				{
				setState(134); parameter();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMAX) {
					{
					{
					setState(135); match(COMAX);
					setState(136); parameter();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144); match(T__4);
			setState(145); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TerminalNode CHARX() { return getToken(DECAF2Parser.CHARX, 0); }
		public TerminalNode INTX() { return getToken(DECAF2Parser.INTX, 0); }
		public TerminalNode BOOLEANX() { return getToken(DECAF2Parser.BOOLEANX, 0); }
		public TerminalNode VOIDX() { return getToken(DECAF2Parser.VOIDX, 0); }
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitMethodType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitMethodType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOIDX) | (1L << INTX) | (1L << CHARX) | (1L << BOOLEANX))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public ParameterTypeContext parameterType() {
			return getRuleContext(ParameterTypeContext.class,0);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public TerminalNode NUMX() { return getToken(DECAF2Parser.NUMX, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149); parameterType();
				setState(150); match(IDX);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); parameterType();
				setState(153); match(IDX);
				setState(154); match(T__17);
				setState(155); match(NUMX);
				setState(156); match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterTypeContext extends ParserRuleContext {
		public TerminalNode CHARX() { return getToken(DECAF2Parser.CHARX, 0); }
		public TerminalNode INTX() { return getToken(DECAF2Parser.INTX, 0); }
		public TerminalNode BOOLEANX() { return getToken(DECAF2Parser.BOOLEANX, 0); }
		public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterParameterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitParameterType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitParameterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterTypeContext parameterType() throws RecognitionException {
		ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTX) | (1L << CHARX) | (1L << BOOLEANX))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(T__15);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__15) | (1L << T__7) | (1L << T__5) | (1L << T__1) | (1L << STRUCTX) | (1L << TRUEX) | (1L << FALSEX) | (1L << VOIDX) | (1L << IFX) | (1L << WHILEX) | (1L << RETURNX) | (1L << INTX) | (1L << CHARX) | (1L << BOOLEANX) | (1L << IDX) | (1L << NUMX) | (1L << CHARY))) != 0)) {
				{
				setState(165);
				switch (_input.LA(1)) {
				case STRUCTX:
				case VOIDX:
				case INTX:
				case CHARX:
				case BOOLEANX:
					{
					setState(163); varDeclaration();
					}
					break;
				case T__16:
				case T__15:
				case T__7:
				case T__5:
				case T__1:
				case TRUEX:
				case FALSEX:
				case IFX:
				case WHILEX:
				case RETURNX:
				case IDX:
				case NUMX:
				case CHARY:
					{
					setState(164); statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ReturnSContext returnS() {
			return getRuleContext(ReturnSContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileSContext whileS() {
			return getRuleContext(WhileSContext.class,0);
		}
		public IfSContext ifS() {
			return getRuleContext(IfSContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); ifS();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173); whileS();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174); returnS();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175); methodCall();
				setState(176); match(T__16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178); block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179); assign();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(181);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__5) | (1L << T__1) | (1L << TRUEX) | (1L << FALSEX) | (1L << IDX) | (1L << NUMX) | (1L << CHARY))) != 0)) {
					{
					setState(180); expression(0);
					}
				}

				setState(183); match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); location();
			setState(187); match(T__12);
			setState(188); expression(0);
			setState(189); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfSContext extends ParserRuleContext {
		public ElseSContext elseS() {
			return getRuleContext(ElseSContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IFX() { return getToken(DECAF2Parser.IFX, 0); }
		public IfSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterIfS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitIfS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitIfS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfSContext ifS() throws RecognitionException {
		IfSContext _localctx = new IfSContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(IFX);
			setState(192); match(T__5);
			setState(193); expression(0);
			setState(194); match(T__4);
			setState(195); block();
			setState(197);
			_la = _input.LA(1);
			if (_la==ELSEX) {
				{
				setState(196); elseS();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseSContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ELSEX() { return getToken(DECAF2Parser.ELSEX, 0); }
		public ElseSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterElseS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitElseS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitElseS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseSContext elseS() throws RecognitionException {
		ElseSContext _localctx = new ElseSContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(ELSEX);
			setState(200); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnSContext extends ParserRuleContext {
		public TerminalNode RETURNX() { return getToken(DECAF2Parser.RETURNX, 0); }
		public ExpressionNuevaContext expressionNueva() {
			return getRuleContext(ExpressionNuevaContext.class,0);
		}
		public ReturnSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterReturnS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitReturnS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitReturnS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnSContext returnS() throws RecognitionException {
		ReturnSContext _localctx = new ReturnSContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(RETURNX);
			{
			setState(203); expressionNueva();
			}
			setState(204); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileSContext extends ParserRuleContext {
		public TerminalNode WHILEX() { return getToken(DECAF2Parser.WHILEX, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterWhileS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitWhileS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitWhileS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileSContext whileS() throws RecognitionException {
		WhileSContext _localctx = new WhileSContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(WHILEX);
			setState(207); match(T__5);
			setState(208); expression(0);
			setState(209); match(T__4);
			setState(210); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public StructLocationContext structLocation() {
			return getRuleContext(StructLocationContext.class,0);
		}
		public SimpleLocationContext simpleLocation() {
			return getRuleContext(SimpleLocationContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_location);
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212); simpleLocation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213); structLocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructLocationContext extends ParserRuleContext {
		public ArrayVariableContext arrayVariable() {
			return getRuleContext(ArrayVariableContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public SimpleVariableContext simpleVariable() {
			return getRuleContext(SimpleVariableContext.class,0);
		}
		public StructLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterStructLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitStructLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitStructLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructLocationContext structLocation() throws RecognitionException {
		StructLocationContext _localctx = new StructLocationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_structLocation);
		try {
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); simpleVariable();
				{
				setState(217); match(T__0);
				setState(218); location();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); arrayVariable();
				{
				setState(221); match(T__0);
				setState(222); location();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleLocationContext extends ParserRuleContext {
		public ArrayVariableContext arrayVariable() {
			return getRuleContext(ArrayVariableContext.class,0);
		}
		public SimpleVariableContext simpleVariable() {
			return getRuleContext(SimpleVariableContext.class,0);
		}
		public SimpleLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLocationContext simpleLocation() throws RecognitionException {
		SimpleLocationContext _localctx = new SimpleLocationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_simpleLocation);
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226); simpleVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227); arrayVariable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleVariableContext extends ParserRuleContext {
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public SimpleVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleVariableContext simpleVariable() throws RecognitionException {
		SimpleVariableContext _localctx = new SimpleVariableContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simpleVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(IDX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayVariableContext extends ParserRuleContext {
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterArrayVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitArrayVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitArrayVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayVariableContext arrayVariable() throws RecognitionException {
		ArrayVariableContext _localctx = new ArrayVariableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arrayVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(IDX);
			setState(233); match(T__17);
			setState(234); expression(0);
			setState(235); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp1Context extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Exp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterExp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitExp1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitExp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp1Context exp1() throws RecognitionException {
		Exp1Context _localctx = new Exp1Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_exp1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(T__5);
			setState(238); expression(0);
			setState(239); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionNuevaContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionNuevaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionNueva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterExpressionNueva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitExpressionNueva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitExpressionNueva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionNuevaContext expressionNueva() throws RecognitionException {
		ExpressionNuevaContext _localctx = new ExpressionNuevaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionNueva);
		try {
			setState(243);
			switch (_input.LA(1)) {
			case T__7:
			case T__5:
			case T__1:
			case TRUEX:
			case FALSEX:
			case IDX:
			case NUMX:
			case CHARY:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); expression(0);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleAndExprContext extends ExpressionContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public SimpleAndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrConditionExprContext extends ExpressionContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(DECAF2Parser.OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OrConditionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterOrConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitOrConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitOrConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleAndExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(246); andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrConditionExprContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(248);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(249); match(OR);
					setState(250); andExpr(0);
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
	 
		public AndExprContext() { }
		public void copyFrom(AndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndConditionExprContext extends AndExprContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(DECAF2Parser.AND, 0); }
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public AndConditionExprContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterAndConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitAndConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitAndConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleEqExprContext extends AndExprContext {
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public SimpleEqExprContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleEqExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(257); eqExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndConditionExprContext(new AndExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(259);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(260); match(AND);
					setState(261); eqExpr(0);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqExprContext extends ParserRuleContext {
		public EqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExpr; }
	 
		public EqExprContext() { }
		public void copyFrom(EqExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleRelationExprContext extends EqExprContext {
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public SimpleRelationExprContext(EqExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleRelationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleRelationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleRelationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqIneqExprContext extends EqExprContext {
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public EqIneqExprContext(EqExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterEqIneqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitEqIneqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitEqIneqExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExprContext eqExpr() throws RecognitionException {
		return eqExpr(0);
	}

	private EqExprContext eqExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqExprContext _localctx = new EqExprContext(_ctx, _parentState);
		EqExprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_eqExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleRelationExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(268); relationExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqIneqExprContext(new EqExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_eqExpr);
					setState(270);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(271); eq_op();
					setState(272); relationExpr(0);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationExprContext extends ParserRuleContext {
		public RelationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpr; }
	 
		public RelationExprContext() { }
		public void copyFrom(RelationExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalExprContext extends RelationExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public ConditionalExprContext(RelationExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterConditionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitConditionalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitConditionalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleAddExprContext extends RelationExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public SimpleAddExprContext(RelationExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationExprContext relationExpr() throws RecognitionException {
		return relationExpr(0);
	}

	private RelationExprContext relationExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationExprContext _localctx = new RelationExprContext(_ctx, _parentState);
		RelationExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_relationExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleAddExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(280); addExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalExprContext(new RelationExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
					setState(282);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(283); rel_op();
					setState(284); addExpr(0);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddExprContext extends ParserRuleContext {
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	 
		public AddExprContext() { }
		public void copyFrom(AddExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleMultExprContext extends AddExprContext {
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public SimpleMultExprContext(AddExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddDiffExprContext extends AddExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public Add_opContext add_op() {
			return getRuleContext(Add_opContext.class,0);
		}
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public AddDiffExprContext(AddExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterAddDiffExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitAddDiffExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitAddDiffExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		return addExpr(0);
	}

	private AddExprContext addExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExprContext _localctx = new AddExprContext(_ctx, _parentState);
		AddExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_addExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleMultExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(292); multExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddDiffExprContext(new AddExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
					setState(294);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(295); add_op();
					setState(296); multExpr(0);
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultExprContext extends ParserRuleContext {
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	 
		public MultExprContext() { }
		public void copyFrom(MultExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultDivExprContext extends MultExprContext {
		public Mult_opContext mult_op() {
			return getRuleContext(Mult_opContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public MultDivExprContext(MultExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterMultDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitMultDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitMultDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleUnaryExprContext extends MultExprContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public SimpleUnaryExprContext(MultExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterSimpleUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitSimpleUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitSimpleUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		return multExpr(0);
	}

	private MultExprContext multExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultExprContext _localctx = new MultExprContext(_ctx, _parentState);
		MultExprContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_multExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleUnaryExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(304); unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultDivExprContext(new MultExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_multExpr);
					setState(306);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(307); mult_op();
					setState(308); unaryExpr();
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode CHARX() { return getToken(DECAF2Parser.CHARX, 0); }
		public TerminalNode INTX() { return getToken(DECAF2Parser.INTX, 0); }
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unaryExpr);
		int _la;
		try {
			setState(324);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(315); match(T__5);
				setState(316);
				_la = _input.LA(1);
				if ( !(_la==INTX || _la==CHARX) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(317); match(T__4);
				setState(318); value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319); match(T__1);
				setState(320); value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(321); match(T__7);
				setState(322); value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(323); value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_value);
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326); location();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327); methodCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(328); literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(329); exp1();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public TerminalNode IDX() { return getToken(DECAF2Parser.IDX, 0); }
		public List<TerminalNode> COMAX() { return getTokens(DECAF2Parser.COMAX); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public TerminalNode COMAX(int i) {
			return getToken(DECAF2Parser.COMAX, i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(IDX);
			setState(333); match(T__5);
			setState(342);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__5) | (1L << T__1) | (1L << TRUEX) | (1L << FALSEX) | (1L << IDX) | (1L << NUMX) | (1L << CHARY))) != 0)) {
				{
				setState(334); arg();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMAX) {
					{
					{
					setState(335); match(COMAX);
					setState(336); arg();
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(344); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_opContext extends ParserRuleContext {
		public Add_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterAdd_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitAdd_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitAdd_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_opContext add_op() throws RecognitionException {
		Add_opContext _localctx = new Add_opContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_add_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_opContext extends ParserRuleContext {
		public Mult_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterMult_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitMult_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitMult_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_opContext mult_op() throws RecognitionException {
		Mult_opContext _localctx = new Mult_opContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mult_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__6) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_opContext extends ParserRuleContext {
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterRel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitRel_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitRel_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__13) | (1L << T__9) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Eq_opContext extends ParserRuleContext {
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterEq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitEq_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitEq_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_literal);
		try {
			setState(359);
			switch (_input.LA(1)) {
			case NUMX:
				enterOuterAlt(_localctx, 1);
				{
				setState(356); int_literal();
				}
				break;
			case CHARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(357); char_literal();
				}
				break;
			case TRUEX:
			case FALSEX:
				enterOuterAlt(_localctx, 3);
				{
				setState(358); bool_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode NUMX() { return getToken(DECAF2Parser.NUMX, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitInt_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitInt_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361); match(NUMX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHARY() { return getToken(DECAF2Parser.CHARY, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitChar_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitChar_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363); match(CHARY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literalContext extends ParserRuleContext {
		public TerminalNode TRUEX() { return getToken(DECAF2Parser.TRUEX, 0); }
		public TerminalNode FALSEX() { return getToken(DECAF2Parser.FALSEX, 0); }
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DECAF2Listener ) ((DECAF2Listener)listener).exitBool_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DECAF2Visitor ) return ((DECAF2Visitor<? extends T>)visitor).visitBool_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !(_la==TRUEX || _la==FALSEX) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 24: return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 25: return eqExpr_sempred((EqExprContext)_localctx, predIndex);
		case 26: return relationExpr_sempred((RelationExprContext)_localctx, predIndex);
		case 27: return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 28: return multExpr_sempred((MultExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean eqExpr_sempred(EqExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addExpr_sempred(AddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multExpr_sempred(MultExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationExpr_sempred(RelationExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u0172\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\7\2Y\n\2\f\2\16\2\\\13\2\3\2\3\2\3\3\3\3\3\3\5\3c\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\5\3\5\3\5\3\5\7\5v\n\5"+
		"\f\5\16\5y\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0084\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f\13\7\5\7\u0091\n\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a1\n\t\3"+
		"\n\3\n\3\13\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b8\n\f\3\f\5\f\u00bb\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c8\n\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\5\22\u00d9\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e3\n"+
		"\23\3\24\3\24\5\24\u00e7\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\5\30\u00f6\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u00fe\n\31\f\31\16\31\u0101\13\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0109\n\32\f\32\16\32\u010c\13\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0115\n\33\f\33\16\33\u0118\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\7\34\u0121\n\34\f\34\16\34\u0124\13\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\7\35\u012d\n\35\f\35\16\35\u0130\13\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\7\36\u0139\n\36\f\36\16\36\u013c\13\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0147\n\37\3 \3 \3 \3 \5 \u014d"+
		"\n \3!\3!\3!\3!\3!\7!\u0154\n!\f!\16!\u0157\13!\5!\u0159\n!\3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\5\'\u016a\n\'\3(\3(\3)\3)\3*"+
		"\3*\3*\2\b\60\62\64\668:+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLNPR\2\n\4\2\34\34!#\3\2!#\3\2!\"\3\2\25\26"+
		"\5\2\3\3\21\21\24\24\5\2\5\5\n\n\16\17\4\2\4\4\t\t\3\2\32\33\u0173\2T"+
		"\3\2\2\2\4b\3\2\2\2\6o\3\2\2\2\bq\3\2\2\2\n\u0083\3\2\2\2\f\u0085\3\2"+
		"\2\2\16\u0095\3\2\2\2\20\u00a0\3\2\2\2\22\u00a2\3\2\2\2\24\u00a4\3\2\2"+
		"\2\26\u00ba\3\2\2\2\30\u00bc\3\2\2\2\32\u00c1\3\2\2\2\34\u00c9\3\2\2\2"+
		"\36\u00cc\3\2\2\2 \u00d0\3\2\2\2\"\u00d8\3\2\2\2$\u00e2\3\2\2\2&\u00e6"+
		"\3\2\2\2(\u00e8\3\2\2\2*\u00ea\3\2\2\2,\u00ef\3\2\2\2.\u00f5\3\2\2\2\60"+
		"\u00f7\3\2\2\2\62\u0102\3\2\2\2\64\u010d\3\2\2\2\66\u0119\3\2\2\28\u0125"+
		"\3\2\2\2:\u0131\3\2\2\2<\u0146\3\2\2\2>\u014c\3\2\2\2@\u014e\3\2\2\2B"+
		"\u015c\3\2\2\2D\u015e\3\2\2\2F\u0160\3\2\2\2H\u0162\3\2\2\2J\u0164\3\2"+
		"\2\2L\u0169\3\2\2\2N\u016b\3\2\2\2P\u016d\3\2\2\2R\u016f\3\2\2\2TU\7\30"+
		"\2\2UV\7$\2\2VZ\7\b\2\2WY\5\4\3\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\r\2\2^\3\3\2\2\2_c\5\b\5\2`c\5\6\4\2ac\5"+
		"\f\7\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\5\3\2\2\2de\5\n\6\2ef\7$\2\2fg\7"+
		"\7\2\2gp\3\2\2\2hi\5\n\6\2ij\7$\2\2jk\7\6\2\2kl\7%\2\2lm\7\f\2\2mn\7\7"+
		"\2\2np\3\2\2\2od\3\2\2\2oh\3\2\2\2p\7\3\2\2\2qr\7\31\2\2rs\7$\2\2sw\7"+
		"\b\2\2tv\5\6\4\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3"+
		"\2\2\2z{\7\r\2\2{\t\3\2\2\2|\u0084\7!\2\2}\u0084\7\"\2\2~\u0084\7#\2\2"+
		"\177\u0080\7\31\2\2\u0080\u0084\7$\2\2\u0081\u0084\5\b\5\2\u0082\u0084"+
		"\7\34\2\2\u0083|\3\2\2\2\u0083}\3\2\2\2\u0083~\3\2\2\2\u0083\177\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\13\3\2\2\2\u0085\u0086"+
		"\5\16\b\2\u0086\u0087\7$\2\2\u0087\u0090\7\22\2\2\u0088\u008d\5\20\t\2"+
		"\u0089\u008a\7)\2\2\u008a\u008c\5\20\t\2\u008b\u0089\3\2\2\2\u008c\u008f"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\7\23\2\2\u0093\u0094\5\24\13\2\u0094\r\3\2\2\2\u0095"+
		"\u0096\t\2\2\2\u0096\17\3\2\2\2\u0097\u0098\5\22\n\2\u0098\u0099\7$\2"+
		"\2\u0099\u00a1\3\2\2\2\u009a\u009b\5\22\n\2\u009b\u009c\7$\2\2\u009c\u009d"+
		"\7\6\2\2\u009d\u009e\7%\2\2\u009e\u009f\7\f\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u0097\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1\21\3\2\2\2\u00a2\u00a3\t\3\2"+
		"\2\u00a3\23\3\2\2\2\u00a4\u00a9\7\b\2\2\u00a5\u00a8\5\6\4\2\u00a6\u00a8"+
		"\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7\r\2\2\u00ad\25\3\2\2\2\u00ae\u00bb\5\32\16\2\u00af"+
		"\u00bb\5 \21\2\u00b0\u00bb\5\36\20\2\u00b1\u00b2\5@!\2\u00b2\u00b3\7\7"+
		"\2\2\u00b3\u00bb\3\2\2\2\u00b4\u00bb\5\24\13\2\u00b5\u00bb\5\30\r\2\u00b6"+
		"\u00b8\5\60\31\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3"+
		"\2\2\2\u00b9\u00bb\7\7\2\2\u00ba\u00ae\3\2\2\2\u00ba\u00af\3\2\2\2\u00ba"+
		"\u00b0\3\2\2\2\u00ba\u00b1\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b5\3\2"+
		"\2\2\u00ba\u00b7\3\2\2\2\u00bb\27\3\2\2\2\u00bc\u00bd\5\"\22\2\u00bd\u00be"+
		"\7\13\2\2\u00be\u00bf\5\60\31\2\u00bf\u00c0\7\7\2\2\u00c0\31\3\2\2\2\u00c1"+
		"\u00c2\7\35\2\2\u00c2\u00c3\7\22\2\2\u00c3\u00c4\5\60\31\2\u00c4\u00c5"+
		"\7\23\2\2\u00c5\u00c7\5\24\13\2\u00c6\u00c8\5\34\17\2\u00c7\u00c6\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\36\2\2\u00ca\u00cb"+
		"\5\24\13\2\u00cb\35\3\2\2\2\u00cc\u00cd\7 \2\2\u00cd\u00ce\5.\30\2\u00ce"+
		"\u00cf\7\7\2\2\u00cf\37\3\2\2\2\u00d0\u00d1\7\37\2\2\u00d1\u00d2\7\22"+
		"\2\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4\7\23\2\2\u00d4\u00d5\5\24\13\2"+
		"\u00d5!\3\2\2\2\u00d6\u00d9\5&\24\2\u00d7\u00d9\5$\23\2\u00d8\u00d6\3"+
		"\2\2\2\u00d8\u00d7\3\2\2\2\u00d9#\3\2\2\2\u00da\u00db\5(\25\2\u00db\u00dc"+
		"\7\27\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00e3\3\2\2\2\u00de\u00df\5*\26\2"+
		"\u00df\u00e0\7\27\2\2\u00e0\u00e1\5\"\22\2\u00e1\u00e3\3\2\2\2\u00e2\u00da"+
		"\3\2\2\2\u00e2\u00de\3\2\2\2\u00e3%\3\2\2\2\u00e4\u00e7\5(\25\2\u00e5"+
		"\u00e7\5*\26\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\'\3\2\2\2"+
		"\u00e8\u00e9\7$\2\2\u00e9)\3\2\2\2\u00ea\u00eb\7$\2\2\u00eb\u00ec\7\6"+
		"\2\2\u00ec\u00ed\5\60\31\2\u00ed\u00ee\7\f\2\2\u00ee+\3\2\2\2\u00ef\u00f0"+
		"\7\22\2\2\u00f0\u00f1\5\60\31\2\u00f1\u00f2\7\23\2\2\u00f2-\3\2\2\2\u00f3"+
		"\u00f6\5\60\31\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3"+
		"\2\2\2\u00f6/\3\2\2\2\u00f7\u00f8\b\31\1\2\u00f8\u00f9\5\62\32\2\u00f9"+
		"\u00ff\3\2\2\2\u00fa\u00fb\f\3\2\2\u00fb\u00fc\7,\2\2\u00fc\u00fe\5\62"+
		"\32\2\u00fd\u00fa\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\61\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\b\32\1"+
		"\2\u0103\u0104\5\64\33\2\u0104\u010a\3\2\2\2\u0105\u0106\f\3\2\2\u0106"+
		"\u0107\7+\2\2\u0107\u0109\5\64\33\2\u0108\u0105\3\2\2\2\u0109\u010c\3"+
		"\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\63\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010d\u010e\b\33\1\2\u010e\u010f\5\66\34\2\u010f\u0116"+
		"\3\2\2\2\u0110\u0111\f\3\2\2\u0111\u0112\5J&\2\u0112\u0113\5\66\34\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\65\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a"+
		"\b\34\1\2\u011a\u011b\58\35\2\u011b\u0122\3\2\2\2\u011c\u011d\f\3\2\2"+
		"\u011d\u011e\5H%\2\u011e\u011f\58\35\2\u011f\u0121\3\2\2\2\u0120\u011c"+
		"\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\67\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\b\35\1\2\u0126\u0127\5:\36"+
		"\2\u0127\u012e\3\2\2\2\u0128\u0129\f\3\2\2\u0129\u012a\5D#\2\u012a\u012b"+
		"\5:\36\2\u012b\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f9\3\2\2\2\u0130\u012e\3\2\2\2"+
		"\u0131\u0132\b\36\1\2\u0132\u0133\5<\37\2\u0133\u013a\3\2\2\2\u0134\u0135"+
		"\f\3\2\2\u0135\u0136\5F$\2\u0136\u0137\5<\37\2\u0137\u0139\3\2\2\2\u0138"+
		"\u0134\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013b;\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\7\22\2\2\u013e\u013f"+
		"\t\4\2\2\u013f\u0140\7\23\2\2\u0140\u0147\5> \2\u0141\u0142\7\26\2\2\u0142"+
		"\u0147\5> \2\u0143\u0144\7\20\2\2\u0144\u0147\5> \2\u0145\u0147\5> \2"+
		"\u0146\u013d\3\2\2\2\u0146\u0141\3\2\2\2\u0146\u0143\3\2\2\2\u0146\u0145"+
		"\3\2\2\2\u0147=\3\2\2\2\u0148\u014d\5\"\22\2\u0149\u014d\5@!\2\u014a\u014d"+
		"\5L\'\2\u014b\u014d\5,\27\2\u014c\u0148\3\2\2\2\u014c\u0149\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014d?\3\2\2\2\u014e\u014f\7$\2\2\u014f"+
		"\u0158\7\22\2\2\u0150\u0155\5B\"\2\u0151\u0152\7)\2\2\u0152\u0154\5B\""+
		"\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156"+
		"\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0150\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\7\23\2\2\u015bA\3\2\2\2"+
		"\u015c\u015d\5\60\31\2\u015dC\3\2\2\2\u015e\u015f\t\5\2\2\u015fE\3\2\2"+
		"\2\u0160\u0161\t\6\2\2\u0161G\3\2\2\2\u0162\u0163\t\7\2\2\u0163I\3\2\2"+
		"\2\u0164\u0165\t\b\2\2\u0165K\3\2\2\2\u0166\u016a\5N(\2\u0167\u016a\5"+
		"P)\2\u0168\u016a\5R*\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u0168"+
		"\3\2\2\2\u016aM\3\2\2\2\u016b\u016c\7%\2\2\u016cO\3\2\2\2\u016d\u016e"+
		"\7&\2\2\u016eQ\3\2\2\2\u016f\u0170\t\t\2\2\u0170S\3\2\2\2\36Zbow\u0083"+
		"\u008d\u0090\u00a0\u00a7\u00a9\u00b7\u00ba\u00c7\u00d8\u00e2\u00e6\u00f5"+
		"\u00ff\u010a\u0116\u0122\u012e\u013a\u0146\u014c\u0155\u0158\u0169";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}