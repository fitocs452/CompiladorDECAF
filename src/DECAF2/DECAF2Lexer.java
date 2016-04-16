// Generated from C:\Users\GustavoAdolfo\Documents\NetBeansProjects\DECAF_GRAMMAR\src\DECAF2\DECAF2.g4 by ANTLR 4.4
package DECAF2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DECAF2Lexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'"
	};
	public static final String[] ruleNames = {
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "CLASSX", "STRUCTX", "TRUEX", "FALSEX", 
		"VOIDX", "IFX", "ELSEX", "WHILEX", "RETURNX", "INTX", "CHARX", "BOOLEANX", 
		"LETTERX", "DIGITX", "VARX", "IDX", "NUMX", "CHARY", "SPACEX", "COMMENTX", 
		"COMAX", "WS", "AND", "OR"
	};


	public DECAF2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DECAF2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 39: SPACEX_action((RuleContext)_localctx, actionIndex); break;
		case 40: COMMENTX_action((RuleContext)_localctx, actionIndex); break;
		case 42: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void COMMENTX_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}
	private void SPACEX_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2,\u0111\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3%\5%\u00d4\n%\3&"+
		"\3&\3&\7&\u00d9\n&\f&\16&\u00dc\13&\3\'\3\'\7\'\u00e0\n\'\f\'\16\'\u00e3"+
		"\13\'\3(\3(\3(\3(\3(\3(\3(\5(\u00ec\n(\3(\3(\3)\3)\3)\3)\5)\u00f4\n)\3"+
		")\3)\3*\3*\3*\3*\7*\u00fc\n*\f*\16*\u00ff\13*\3*\3*\3+\3+\3,\6,\u0106"+
		"\n,\r,\16,\u0107\3,\3,\3-\3-\3-\3.\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2K$M%O&Q"+
		"\'S(U)W*Y+[,\3\2\t\4\2C\\c|\4\2\13\f\"\u0080\6\2\"\61<B]b}\177\5\3\f\f"+
		"$$))\5\2\13\f\16\16\"\"\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0118\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\3]\3\2\2\2\5_\3\2\2\2\7b\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2"+
		"\17k\3\2\2\2\21n\3\2\2\2\23p\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31v\3\2\2"+
		"\2\33x\3\2\2\2\35{\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083"+
		"\3\2\2\2\'\u0085\3\2\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u008b\3\2\2\2"+
		"/\u0091\3\2\2\2\61\u0098\3\2\2\2\63\u009d\3\2\2\2\65\u00a3\3\2\2\2\67"+
		"\u00a8\3\2\2\29\u00ab\3\2\2\2;\u00b0\3\2\2\2=\u00b6\3\2\2\2?\u00bd\3\2"+
		"\2\2A\u00c1\3\2\2\2C\u00c6\3\2\2\2E\u00ce\3\2\2\2G\u00d0\3\2\2\2I\u00d3"+
		"\3\2\2\2K\u00d5\3\2\2\2M\u00dd\3\2\2\2O\u00e4\3\2\2\2Q\u00f3\3\2\2\2S"+
		"\u00f7\3\2\2\2U\u0102\3\2\2\2W\u0105\3\2\2\2Y\u010b\3\2\2\2[\u010e\3\2"+
		"\2\2]^\7\61\2\2^\4\3\2\2\2_`\7#\2\2`a\7?\2\2a\6\3\2\2\2bc\7@\2\2cd\7?"+
		"\2\2d\b\3\2\2\2ef\7]\2\2f\n\3\2\2\2gh\7=\2\2h\f\3\2\2\2ij\7}\2\2j\16\3"+
		"\2\2\2kl\7?\2\2lm\7?\2\2m\20\3\2\2\2no\7>\2\2o\22\3\2\2\2pq\7?\2\2q\24"+
		"\3\2\2\2rs\7_\2\2s\26\3\2\2\2tu\7\177\2\2u\30\3\2\2\2vw\7@\2\2w\32\3\2"+
		"\2\2xy\7>\2\2yz\7?\2\2z\34\3\2\2\2{|\7#\2\2|\36\3\2\2\2}~\7\'\2\2~ \3"+
		"\2\2\2\177\u0080\7*\2\2\u0080\"\3\2\2\2\u0081\u0082\7+\2\2\u0082$\3\2"+
		"\2\2\u0083\u0084\7,\2\2\u0084&\3\2\2\2\u0085\u0086\7-\2\2\u0086(\3\2\2"+
		"\2\u0087\u0088\7/\2\2\u0088*\3\2\2\2\u0089\u008a\7\60\2\2\u008a,\3\2\2"+
		"\2\u008b\u008c\7e\2\2\u008c\u008d\7n\2\2\u008d\u008e\7c\2\2\u008e\u008f"+
		"\7u\2\2\u008f\u0090\7u\2\2\u0090.\3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093"+
		"\7v\2\2\u0093\u0094\7t\2\2\u0094\u0095\7w\2\2\u0095\u0096\7e\2\2\u0096"+
		"\u0097\7v\2\2\u0097\60\3\2\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2\u009a"+
		"\u009b\7w\2\2\u009b\u009c\7g\2\2\u009c\62\3\2\2\2\u009d\u009e\7h\2\2\u009e"+
		"\u009f\7c\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2"+
		"\u00a2\64\3\2\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7"+
		"k\2\2\u00a6\u00a7\7f\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa"+
		"\7h\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae"+
		"\7u\2\2\u00ae\u00af\7g\2\2\u00af:\3\2\2\2\u00b0\u00b1\7y\2\2\u00b1\u00b2"+
		"\7j\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"<\3\2\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7v\2\2\u00b9"+
		"\u00ba\7w\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7p\2\2\u00bc>\3\2\2\2\u00bd"+
		"\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7v\2\2\u00c0@\3\2\2\2\u00c1"+
		"\u00c2\7e\2\2\u00c2\u00c3\7j\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7t\2\2"+
		"\u00c5B\3\2\2\2\u00c6\u00c7\7d\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7q\2"+
		"\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd"+
		"\7p\2\2\u00cdD\3\2\2\2\u00ce\u00cf\t\2\2\2\u00cfF\3\2\2\2\u00d0\u00d1"+
		"\4\62;\2\u00d1H\3\2\2\2\u00d2\u00d4\t\3\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"J\3\2\2\2\u00d5\u00da\5E#\2\u00d6\u00d9\5E#\2\u00d7\u00d9\5G$\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00dbL\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e1"+
		"\5G$\2\u00de\u00e0\5G$\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2N\3\2\2\2\u00e3\u00e1\3\2\2\2"+
		"\u00e4\u00eb\7)\2\2\u00e5\u00ec\5E#\2\u00e6\u00ec\5G$\2\u00e7\u00ec\t"+
		"\4\2\2\u00e8\u00e9\7\u0080\2\2\u00e9\u00ec\7\13\2\2\u00ea\u00ec\t\5\2"+
		"\2\u00eb\u00e5\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8"+
		"\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7)\2\2\u00ee"+
		"P\3\2\2\2\u00ef\u00f4\t\6\2\2\u00f0\u00f1\7\17\2\2\u00f1\u00f4\7\f\2\2"+
		"\u00f2\u00f4\7\17\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f2"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b)\2\2\u00f6R\3\2\2\2\u00f7\u00f8"+
		"\7\61\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fd\3\2\2\2\u00fa\u00fc\n\7\2\2"+
		"\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\b*\3\2\u0101"+
		"T\3\2\2\2\u0102\u0103\7.\2\2\u0103V\3\2\2\2\u0104\u0106\t\b\2\2\u0105"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b,\4\2\u010aX\3\2\2\2\u010b\u010c"+
		"\7(\2\2\u010c\u010d\7(\2\2\u010dZ\3\2\2\2\u010e\u010f\7~\2\2\u010f\u0110"+
		"\7~\2\2\u0110\\\3\2\2\2\13\2\u00d3\u00d8\u00da\u00e1\u00eb\u00f3\u00fd"+
		"\u0107\5\3)\2\3*\3\3,\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}