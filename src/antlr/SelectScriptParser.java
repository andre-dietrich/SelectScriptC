// Generated from SelectScript.g4 by ANTLR 4.5.3
package S2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SelectScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, DOT=3, SEP=4, END=5, COLON=6, AD=7, AND=8, XOR=9, OR=10, 
		NOT=11, IN=12, SHIFTR=13, SHIFTL=14, IAND=15, IXOR=16, IOR=17, INV=18, 
		ASSIGN=19, EQ=20, NE=21, LE=22, GE=23, LT=24, GT=25, ADD=26, SUB=27, MUL=28, 
		DIV=29, MOD=30, POW=31, IF=32, SQ=33, DQ=34, LIST_BEGIN=35, LIST_END=36, 
		DICT_BEGIN=37, DICT_END=38, DOLLAR=39, PROCEDURE=40, SELECT=41, FROM=42, 
		WHERE=43, ORDER=44, GROUP=45, HAVING=46, BY=47, LIMIT=48, AS=49, LOC=50, 
		CONNECT=51, START=52, STOP=53, WITH=54, NO=55, CYCLE=56, UNIQUE=57, MEMORIZE=58, 
		COST=59, ASC=60, DESC=61, DEL_F=62, MEM_F=63, EVAL_F=64, LOOP=65, EXIT=66, 
		TRY=67, REF=68, NEWLINE=69, WS=70, COMMENT=71, LINE_COMMENT=72, STRING=73, 
		FLOAT=74, INTEGER=75, TRUE=76, FALSE=77, NONE=78, IDENTIFIER=79;
	public static final int
		RULE_prog = 0, RULE_assign = 1, RULE_atom = 2, RULE_dict = 3, RULE_dict_elem = 4, 
		RULE_dict_id = 5, RULE_element = 6, RULE_expr = 7, RULE_function = 8, 
		RULE_if_expr = 9, RULE_list = 10, RULE_loc = 11, RULE_loop = 12, RULE_repository = 13, 
		RULE_set = 14, RULE_stmt = 15, RULE_stmt_list = 16, RULE_try_expr = 17, 
		RULE_value = 18, RULE_variable = 19;
	public static final String[] ruleNames = {
		"prog", "assign", "atom", "dict", "dict_elem", "dict_id", "element", "expr", 
		"function", "if_expr", "list", "loc", "loop", "repository", "set", "stmt", 
		"stmt_list", "try_expr", "value", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "','", "';'", "':'", "'@'", null, null, null, 
		null, null, null, null, null, null, null, null, "'='", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'''", "'\"'", 
		"'['", "']'", "'{'", "'}'", "'$'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'del'", "'mem'", "'eval'", null, null, null, 
		"'ref'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "DOT", "SEP", "END", "COLON", "AD", "AND", "XOR", "OR", 
		"NOT", "IN", "SHIFTR", "SHIFTL", "IAND", "IXOR", "IOR", "INV", "ASSIGN", 
		"EQ", "NE", "LE", "GE", "LT", "GT", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"POW", "IF", "SQ", "DQ", "LIST_BEGIN", "LIST_END", "DICT_BEGIN", "DICT_END", 
		"DOLLAR", "PROCEDURE", "SELECT", "FROM", "WHERE", "ORDER", "GROUP", "HAVING", 
		"BY", "LIMIT", "AS", "LOC", "CONNECT", "START", "STOP", "WITH", "NO", 
		"CYCLE", "UNIQUE", "MEMORIZE", "COST", "ASC", "DESC", "DEL_F", "MEM_F", 
		"EVAL_F", "LOOP", "EXIT", "TRY", "REF", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT", 
		"STRING", "FLOAT", "INTEGER", "TRUE", "FALSE", "NONE", "IDENTIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SelectScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SelectScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StmtContext stmt;
		public List<StmtContext> elem_ = new ArrayList<StmtContext>();
		public List<TerminalNode> END() { return getTokens(SelectScriptParser.END); }
		public TerminalNode END(int i) {
			return getToken(SelectScriptParser.END, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				((ProgContext)_localctx).stmt = stmt();
				((ProgContext)_localctx).elem_.add(((ProgContext)_localctx).stmt);
				setState(41);
				match(END);
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << LOC))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (TRY - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0) );
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
		public RepositoryContext repo_;
		public StmtContext value_;
		public TerminalNode ASSIGN() { return getToken(SelectScriptParser.ASSIGN, 0); }
		public RepositoryContext repository() {
			return getRuleContext(RepositoryContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((AssignContext)_localctx).repo_ = repository();
			setState(48);
			match(ASSIGN);
			setState(49);
			((AssignContext)_localctx).value_ = stmt();
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

	public static class AtomContext extends ParserRuleContext {
		public StmtContext elem_;
		public RepositoryContext repository() {
			return getRuleContext(RepositoryContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public Try_exprContext try_expr() {
			return getRuleContext(Try_exprContext.class,0);
		}
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public DictContext dict() {
			return getRuleContext(DictContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atom);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				repository();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				if_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				try_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				loc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				loop();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				list();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(58);
				dict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(59);
				set();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(60);
				match(T__0);
				setState(61);
				((AtomContext)_localctx).elem_ = stmt();
				setState(62);
				match(T__1);
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

	public static class DictContext extends ParserRuleContext {
		public Dict_elemContext dict_elem;
		public List<Dict_elemContext> elem_ = new ArrayList<Dict_elemContext>();
		public TerminalNode DICT_BEGIN() { return getToken(SelectScriptParser.DICT_BEGIN, 0); }
		public TerminalNode DICT_END() { return getToken(SelectScriptParser.DICT_END, 0); }
		public List<Dict_elemContext> dict_elem() {
			return getRuleContexts(Dict_elemContext.class);
		}
		public Dict_elemContext dict_elem(int i) {
			return getRuleContext(Dict_elemContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SelectScriptParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SelectScriptParser.SEP, i);
		}
		public DictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitDict(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictContext dict() throws RecognitionException {
		DictContext _localctx = new DictContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(DICT_BEGIN);
			setState(67);
			((DictContext)_localctx).dict_elem = dict_elem();
			((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(68);
				match(SEP);
				setState(69);
				((DictContext)_localctx).dict_elem = dict_elem();
				((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(DICT_END);
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

	public static class Dict_elemContext extends ParserRuleContext {
		public Dict_idContext id_;
		public StmtContext value_;
		public TerminalNode COLON() { return getToken(SelectScriptParser.COLON, 0); }
		public Dict_idContext dict_id() {
			return getRuleContext(Dict_idContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Dict_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitDict_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dict_elemContext dict_elem() throws RecognitionException {
		Dict_elemContext _localctx = new Dict_elemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dict_elem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((Dict_elemContext)_localctx).id_ = dict_id();
			setState(78);
			match(COLON);
			setState(79);
			((Dict_elemContext)_localctx).value_ = stmt();
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

	public static class Dict_idContext extends ParserRuleContext {
		public Token str_;
		public Token id_;
		public TerminalNode STRING() { return getToken(SelectScriptParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public Dict_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitDict_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dict_idContext dict_id() throws RecognitionException {
		Dict_idContext _localctx = new Dict_idContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dict_id);
		try {
			setState(83);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((Dict_idContext)_localctx).str_ = match(STRING);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((Dict_idContext)_localctx).id_ = match(IDENTIFIER);
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

	public static class ElementContext extends ParserRuleContext {
		public VariableContext var_;
		public LocContext loc_;
		public StmtContext stmt_;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> LIST_BEGIN() { return getTokens(SelectScriptParser.LIST_BEGIN); }
		public TerminalNode LIST_BEGIN(int i) {
			return getToken(SelectScriptParser.LIST_BEGIN, i);
		}
		public List<TerminalNode> LIST_END() { return getTokens(SelectScriptParser.LIST_END); }
		public TerminalNode LIST_END(int i) {
			return getToken(SelectScriptParser.LIST_END, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SelectScriptParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SelectScriptParser.DOT, i);
		}
		public List<Dict_idContext> dict_id() {
			return getRuleContexts(Dict_idContext.class);
		}
		public Dict_idContext dict_id(int i) {
			return getRuleContext(Dict_idContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SelectScriptParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SelectScriptParser.SEP, i);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_element);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(85);
				((ElementContext)_localctx).var_ = variable();
				}
				break;
			case 2:
				{
				setState(86);
				((ElementContext)_localctx).loc_ = loc();
				}
				break;
			case 3:
				{
				setState(87);
				match(T__0);
				setState(88);
				((ElementContext)_localctx).stmt_ = stmt();
				setState(89);
				match(T__1);
				}
				break;
			}
			setState(110); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(110);
					switch (_input.LA(1)) {
					case LIST_BEGIN:
						{
						{
						setState(93);
						match(LIST_BEGIN);
						setState(94);
						stmt();
						setState(99);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==SEP) {
							{
							{
							setState(95);
							match(SEP);
							setState(96);
							stmt();
							}
							}
							setState(101);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(102);
						match(LIST_END);
						}
						}
						break;
					case DOT:
						{
						setState(106); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(104);
								match(DOT);
								setState(105);
								dict_id();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(108); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(112); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Ex_elseContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Ex_elseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_else(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_leContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LE() { return getToken(SelectScriptParser.LE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_leContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_le(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_neContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode NE() { return getToken(SelectScriptParser.NE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_neContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_ne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_rightContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode SHIFTR() { return getToken(SelectScriptParser.SHIFTR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_rightContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_right(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_inotContext extends ExprContext {
		public ExprContext e1;
		public TerminalNode INV() { return getToken(SelectScriptParser.INV, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ex_inotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_inot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_ltContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LT() { return getToken(SelectScriptParser.LT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_ltContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_lt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_subContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode SUB() { return getToken(SelectScriptParser.SUB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_subContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_sub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_modContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode MOD() { return getToken(SelectScriptParser.MOD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_modContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_mod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_mulContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode MUL() { return getToken(SelectScriptParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_mulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_mul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_ixorContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode IXOR() { return getToken(SelectScriptParser.IXOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_ixorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_ixor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_leftContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode SHIFTL() { return getToken(SelectScriptParser.SHIFTL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_leftContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_left(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_iandContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode IAND() { return getToken(SelectScriptParser.IAND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_iandContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_iand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_iorContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode IOR() { return getToken(SelectScriptParser.IOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_iorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_ior(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_divContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode DIV() { return getToken(SelectScriptParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_divContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_div(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_negContext extends ExprContext {
		public ExprContext e1;
		public TerminalNode SUB() { return getToken(SelectScriptParser.SUB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ex_negContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_neg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_notContext extends ExprContext {
		public ExprContext e1;
		public TerminalNode NOT() { return getToken(SelectScriptParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ex_notContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_orContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode OR() { return getToken(SelectScriptParser.OR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_orContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_or(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_posContext extends ExprContext {
		public ExprContext e1;
		public TerminalNode ADD() { return getToken(SelectScriptParser.ADD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ex_posContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_pos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_andContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode AND() { return getToken(SelectScriptParser.AND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_andContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_and(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_powContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode POW() { return getToken(SelectScriptParser.POW, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_powContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_pow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_geContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode GE() { return getToken(SelectScriptParser.GE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_geContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_ge(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_xorContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode XOR() { return getToken(SelectScriptParser.XOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_xorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_xor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_addContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode ADD() { return getToken(SelectScriptParser.ADD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_addContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_add(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_inContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode IN() { return getToken(SelectScriptParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_inContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_in(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_exContext extends ExprContext {
		public ExprContext e1;
		public TerminalNode MUL() { return getToken(SelectScriptParser.MUL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ex_exContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_ex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_gtContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode GT() { return getToken(SelectScriptParser.GT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_gtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_gt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ex_eqContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode EQ() { return getToken(SelectScriptParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ex_eqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_eq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			switch (_input.LA(1)) {
			case MUL:
				{
				_localctx = new Ex_exContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				match(MUL);
				setState(116);
				((Ex_exContext)_localctx).e1 = expr(27);
				}
				break;
			case NOT:
				{
				_localctx = new Ex_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(NOT);
				setState(118);
				((Ex_notContext)_localctx).e1 = expr(26);
				}
				break;
			case ADD:
				{
				_localctx = new Ex_posContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(ADD);
				setState(120);
				((Ex_posContext)_localctx).e1 = expr(25);
				}
				break;
			case SUB:
				{
				_localctx = new Ex_negContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(SUB);
				setState(122);
				((Ex_negContext)_localctx).e1 = expr(24);
				}
				break;
			case INV:
				{
				_localctx = new Ex_inotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(INV);
				setState(124);
				((Ex_inotContext)_localctx).e1 = expr(12);
				}
				break;
			case T__0:
			case IF:
			case LIST_BEGIN:
			case DICT_BEGIN:
			case LOC:
			case LOOP:
			case TRY:
			case STRING:
			case FLOAT:
			case INTEGER:
			case TRUE:
			case FALSE:
			case NONE:
			case IDENTIFIER:
				{
				_localctx = new Ex_elseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				switch (_input.LA(1)) {
				case T__0:
				case IF:
				case LIST_BEGIN:
				case DICT_BEGIN:
				case LOC:
				case LOOP:
				case TRY:
				case IDENTIFIER:
					{
					setState(125);
					atom();
					}
					break;
				case STRING:
				case FLOAT:
				case INTEGER:
				case TRUE:
				case FALSE:
				case NONE:
					{
					setState(126);
					value();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(194);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Ex_powContext(new ExprContext(_parentctx, _parentState));
						((Ex_powContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(132);
						match(POW);
						setState(133);
						((Ex_powContext)_localctx).e2 = expr(24);
						}
						break;
					case 2:
						{
						_localctx = new Ex_divContext(new ExprContext(_parentctx, _parentState));
						((Ex_divContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(135);
						match(DIV);
						setState(136);
						((Ex_divContext)_localctx).e2 = expr(23);
						}
						break;
					case 3:
						{
						_localctx = new Ex_modContext(new ExprContext(_parentctx, _parentState));
						((Ex_modContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(138);
						match(MOD);
						setState(139);
						((Ex_modContext)_localctx).e2 = expr(22);
						}
						break;
					case 4:
						{
						_localctx = new Ex_mulContext(new ExprContext(_parentctx, _parentState));
						((Ex_mulContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(141);
						match(MUL);
						setState(142);
						((Ex_mulContext)_localctx).e2 = expr(21);
						}
						break;
					case 5:
						{
						_localctx = new Ex_addContext(new ExprContext(_parentctx, _parentState));
						((Ex_addContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(144);
						match(ADD);
						setState(145);
						((Ex_addContext)_localctx).e2 = expr(20);
						}
						break;
					case 6:
						{
						_localctx = new Ex_subContext(new ExprContext(_parentctx, _parentState));
						((Ex_subContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(147);
						match(SUB);
						setState(148);
						((Ex_subContext)_localctx).e2 = expr(19);
						}
						break;
					case 7:
						{
						_localctx = new Ex_leftContext(new ExprContext(_parentctx, _parentState));
						((Ex_leftContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(150);
						match(SHIFTL);
						setState(151);
						((Ex_leftContext)_localctx).e2 = expr(18);
						}
						break;
					case 8:
						{
						_localctx = new Ex_rightContext(new ExprContext(_parentctx, _parentState));
						((Ex_rightContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(153);
						match(SHIFTR);
						setState(154);
						((Ex_rightContext)_localctx).e2 = expr(17);
						}
						break;
					case 9:
						{
						_localctx = new Ex_iandContext(new ExprContext(_parentctx, _parentState));
						((Ex_iandContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(156);
						match(IAND);
						setState(157);
						((Ex_iandContext)_localctx).e2 = expr(16);
						}
						break;
					case 10:
						{
						_localctx = new Ex_ixorContext(new ExprContext(_parentctx, _parentState));
						((Ex_ixorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(159);
						match(IXOR);
						setState(160);
						((Ex_ixorContext)_localctx).e2 = expr(15);
						}
						break;
					case 11:
						{
						_localctx = new Ex_iorContext(new ExprContext(_parentctx, _parentState));
						((Ex_iorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(162);
						match(IOR);
						setState(163);
						((Ex_iorContext)_localctx).e2 = expr(14);
						}
						break;
					case 12:
						{
						_localctx = new Ex_ltContext(new ExprContext(_parentctx, _parentState));
						((Ex_ltContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(165);
						match(LT);
						setState(166);
						((Ex_ltContext)_localctx).e2 = expr(12);
						}
						break;
					case 13:
						{
						_localctx = new Ex_leContext(new ExprContext(_parentctx, _parentState));
						((Ex_leContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(168);
						match(LE);
						setState(169);
						((Ex_leContext)_localctx).e2 = expr(11);
						}
						break;
					case 14:
						{
						_localctx = new Ex_geContext(new ExprContext(_parentctx, _parentState));
						((Ex_geContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(171);
						match(GE);
						setState(172);
						((Ex_geContext)_localctx).e2 = expr(10);
						}
						break;
					case 15:
						{
						_localctx = new Ex_gtContext(new ExprContext(_parentctx, _parentState));
						((Ex_gtContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(174);
						match(GT);
						setState(175);
						((Ex_gtContext)_localctx).e2 = expr(9);
						}
						break;
					case 16:
						{
						_localctx = new Ex_neContext(new ExprContext(_parentctx, _parentState));
						((Ex_neContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(177);
						match(NE);
						setState(178);
						((Ex_neContext)_localctx).e2 = expr(8);
						}
						break;
					case 17:
						{
						_localctx = new Ex_inContext(new ExprContext(_parentctx, _parentState));
						((Ex_inContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(180);
						match(IN);
						setState(181);
						((Ex_inContext)_localctx).e2 = expr(7);
						}
						break;
					case 18:
						{
						_localctx = new Ex_eqContext(new ExprContext(_parentctx, _parentState));
						((Ex_eqContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(183);
						match(EQ);
						setState(184);
						((Ex_eqContext)_localctx).e2 = expr(6);
						}
						break;
					case 19:
						{
						_localctx = new Ex_andContext(new ExprContext(_parentctx, _parentState));
						((Ex_andContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(186);
						match(AND);
						setState(187);
						((Ex_andContext)_localctx).e2 = expr(5);
						}
						break;
					case 20:
						{
						_localctx = new Ex_xorContext(new ExprContext(_parentctx, _parentState));
						((Ex_xorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(189);
						match(XOR);
						setState(190);
						((Ex_xorContext)_localctx).e2 = expr(4);
						}
						break;
					case 21:
						{
						_localctx = new Ex_orContext(new ExprContext(_parentctx, _parentState));
						((Ex_orContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(192);
						match(OR);
						setState(193);
						((Ex_orContext)_localctx).e2 = expr(3);
						}
						break;
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class FunctionContext extends ParserRuleContext {
		public RepositoryContext repo_;
		public RepositoryContext extra_;
		public Stmt_listContext elem_;
		public List<RepositoryContext> repository() {
			return getRuleContexts(RepositoryContext.class);
		}
		public RepositoryContext repository(int i) {
			return getRuleContext(RepositoryContext.class,i);
		}
		public TerminalNode COLON() { return getToken(SelectScriptParser.COLON, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((FunctionContext)_localctx).repo_ = repository();
			setState(202);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(200);
				match(COLON);
				setState(201);
				((FunctionContext)_localctx).extra_ = repository();
				}
			}

			setState(204);
			match(T__0);
			setState(206);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << LOC))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (TRY - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(205);
				((FunctionContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(208);
			match(T__1);
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

	public static class If_exprContext extends ParserRuleContext {
		public StmtContext if_;
		public StmtContext then_;
		public StmtContext else_;
		public TerminalNode IF() { return getToken(SelectScriptParser.IF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SelectScriptParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SelectScriptParser.SEP, i);
		}
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(IF);
			setState(211);
			match(T__0);
			setState(212);
			((If_exprContext)_localctx).if_ = stmt();
			setState(219);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(213);
				match(SEP);
				setState(214);
				((If_exprContext)_localctx).then_ = stmt();
				setState(217);
				_la = _input.LA(1);
				if (_la==SEP) {
					{
					setState(215);
					match(SEP);
					setState(216);
					((If_exprContext)_localctx).else_ = stmt();
					}
				}

				}
			}

			setState(221);
			match(T__1);
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

	public static class ListContext extends ParserRuleContext {
		public Stmt_listContext elem_;
		public TerminalNode LIST_BEGIN() { return getToken(SelectScriptParser.LIST_BEGIN, 0); }
		public TerminalNode LIST_END() { return getToken(SelectScriptParser.LIST_END, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LIST_BEGIN);
			setState(225);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << LOC))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (TRY - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(224);
				((ListContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(227);
			match(LIST_END);
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

	public static class LocContext extends ParserRuleContext {
		public Token id_;
		public StmtContext extra_;
		public TerminalNode LOC() { return getToken(SelectScriptParser.LOC, 0); }
		public TerminalNode DOT() { return getToken(SelectScriptParser.DOT, 0); }
		public TerminalNode DOLLAR() { return getToken(SelectScriptParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public LocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(229);
				((LocContext)_localctx).id_ = match(IDENTIFIER);
				setState(230);
				match(DOT);
				}
			}

			setState(233);
			match(LOC);
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(234);
				match(DOLLAR);
				setState(235);
				match(T__0);
				setState(236);
				((LocContext)_localctx).extra_ = stmt();
				setState(237);
				match(T__1);
				}
				break;
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

	public static class LoopContext extends ParserRuleContext {
		public StmtContext do_;
		public TerminalNode LOOP() { return getToken(SelectScriptParser.LOOP, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(LOOP);
			setState(242);
			((LoopContext)_localctx).do_ = stmt();
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

	public static class RepositoryContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public RepositoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repository; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitRepository(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepositoryContext repository() throws RecognitionException {
		RepositoryContext _localctx = new RepositoryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_repository);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				element();
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

	public static class SetContext extends ParserRuleContext {
		public Stmt_listContext elem_;
		public TerminalNode DICT_BEGIN() { return getToken(SelectScriptParser.DICT_BEGIN, 0); }
		public TerminalNode DICT_END() { return getToken(SelectScriptParser.DICT_END, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(DICT_BEGIN);
			setState(250);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << LOC))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (TRY - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(249);
				((SetContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(252);
			match(DICT_END);
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

	public static class StmtContext extends ParserRuleContext {
		public ProgContext seq_;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stmt);
		try {
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(T__0);
				setState(257);
				((StmtContext)_localctx).seq_ = prog();
				setState(258);
				match(T__1);
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

	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt;
		public List<StmtContext> elem_ = new ArrayList<StmtContext>();
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SelectScriptParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SelectScriptParser.SEP, i);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			((Stmt_listContext)_localctx).stmt = stmt();
			((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(263);
				match(SEP);
				setState(264);
				((Stmt_listContext)_localctx).stmt = stmt();
				((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Try_exprContext extends ParserRuleContext {
		public StmtContext try_;
		public StmtContext catch_;
		public TerminalNode TRY() { return getToken(SelectScriptParser.TRY, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode SEP() { return getToken(SelectScriptParser.SEP, 0); }
		public Try_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitTry_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_exprContext try_expr() throws RecognitionException {
		Try_exprContext _localctx = new Try_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_try_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(TRY);
			setState(271);
			match(T__0);
			setState(272);
			((Try_exprContext)_localctx).try_ = stmt();
			setState(275);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(273);
				match(SEP);
				setState(274);
				((Try_exprContext)_localctx).catch_ = stmt();
				}
			}

			setState(277);
			match(T__1);
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
		public Token str_;
		public Token float_;
		public Token int_;
		public Token true_;
		public Token false_;
		public Token none_;
		public TerminalNode STRING() { return getToken(SelectScriptParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(SelectScriptParser.FLOAT, 0); }
		public TerminalNode INTEGER() { return getToken(SelectScriptParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(SelectScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SelectScriptParser.FALSE, 0); }
		public TerminalNode NONE() { return getToken(SelectScriptParser.NONE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_value);
		try {
			setState(285);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				((ValueContext)_localctx).str_ = match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				((ValueContext)_localctx).float_ = match(FLOAT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				((ValueContext)_localctx).int_ = match(INTEGER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				((ValueContext)_localctx).true_ = match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				((ValueContext)_localctx).false_ = match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				((ValueContext)_localctx).none_ = match(NONE);
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

	public static class VariableContext extends ParserRuleContext {
		public Token name_;
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			((VariableContext)_localctx).name_ = match(IDENTIFIER);
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
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 23);
		case 1:
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 14);
		case 10:
			return precpred(_ctx, 13);
		case 11:
			return precpred(_ctx, 11);
		case 12:
			return precpred(_ctx, 10);
		case 13:
			return precpred(_ctx, 9);
		case 14:
			return precpred(_ctx, 8);
		case 15:
			return precpred(_ctx, 7);
		case 16:
			return precpred(_ctx, 6);
		case 17:
			return precpred(_ctx, 5);
		case 18:
			return precpred(_ctx, 4);
		case 19:
			return precpred(_ctx, 3);
		case 20:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u0124\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\6\2.\n\2\r\2\16\2/\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4"+
		"\3\5\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\5\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b^\n\b\3\b\3\b\3\b\3\b\7\bd\n\b"+
		"\f\b\16\bg\13\b\3\b\3\b\3\b\3\b\6\bm\n\b\r\b\16\bn\6\bq\n\b\r\b\16\br"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0082\n\t\5\t"+
		"\u0084\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c5\n\t\f\t"+
		"\16\t\u00c8\13\t\3\n\3\n\3\n\5\n\u00cd\n\n\3\n\3\n\5\n\u00d1\n\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00dc\n\13\5\13\u00de\n\13"+
		"\3\13\3\13\3\f\3\f\5\f\u00e4\n\f\3\f\3\f\3\r\3\r\5\r\u00ea\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00f2\n\r\3\16\3\16\3\16\3\17\3\17\5\17\u00f9\n\17"+
		"\3\20\3\20\5\20\u00fd\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0107\n\21\3\22\3\22\3\22\7\22\u010c\n\22\f\22\16\22\u010f\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0116\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0120\n\24\3\25\3\25\3\25\2\3\20\26\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(\2\2\u014e\2-\3\2\2\2\4\61\3\2\2\2\6B\3\2\2\2\bD"+
		"\3\2\2\2\nO\3\2\2\2\fU\3\2\2\2\16]\3\2\2\2\20\u0083\3\2\2\2\22\u00c9\3"+
		"\2\2\2\24\u00d4\3\2\2\2\26\u00e1\3\2\2\2\30\u00e9\3\2\2\2\32\u00f3\3\2"+
		"\2\2\34\u00f8\3\2\2\2\36\u00fa\3\2\2\2 \u0106\3\2\2\2\"\u0108\3\2\2\2"+
		"$\u0110\3\2\2\2&\u011f\3\2\2\2(\u0121\3\2\2\2*+\5 \21\2+,\7\7\2\2,.\3"+
		"\2\2\2-*\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61\62\5"+
		"\34\17\2\62\63\7\25\2\2\63\64\5 \21\2\64\5\3\2\2\2\65C\5\34\17\2\66C\5"+
		"\22\n\2\67C\5\24\13\28C\5$\23\29C\5\30\r\2:C\5\32\16\2;C\5\26\f\2<C\5"+
		"\b\5\2=C\5\36\20\2>?\7\3\2\2?@\5 \21\2@A\7\4\2\2AC\3\2\2\2B\65\3\2\2\2"+
		"B\66\3\2\2\2B\67\3\2\2\2B8\3\2\2\2B9\3\2\2\2B:\3\2\2\2B;\3\2\2\2B<\3\2"+
		"\2\2B=\3\2\2\2B>\3\2\2\2C\7\3\2\2\2DE\7\'\2\2EJ\5\n\6\2FG\7\6\2\2GI\5"+
		"\n\6\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7"+
		"(\2\2N\t\3\2\2\2OP\5\f\7\2PQ\7\b\2\2QR\5 \21\2R\13\3\2\2\2SV\7K\2\2TV"+
		"\7Q\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2W^\5(\25\2X^\5\30\r\2YZ\7\3\2\2"+
		"Z[\5 \21\2[\\\7\4\2\2\\^\3\2\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2^p\3\2\2"+
		"\2_`\7%\2\2`e\5 \21\2ab\7\6\2\2bd\5 \21\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7&\2\2iq\3\2\2\2jk\7\5\2\2km\5\f\7"+
		"\2lj\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2p_\3\2\2\2pl\3\2\2"+
		"\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tu\b\t\1\2uv\7\36\2\2v\u0084"+
		"\5\20\t\35wx\7\r\2\2x\u0084\5\20\t\34yz\7\34\2\2z\u0084\5\20\t\33{|\7"+
		"\35\2\2|\u0084\5\20\t\32}~\7\24\2\2~\u0084\5\20\t\16\177\u0082\5\6\4\2"+
		"\u0080\u0082\5&\24\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083t\3\2\2\2\u0083w\3\2\2\2\u0083y\3\2\2\2\u0083{\3\2\2\2\u0083"+
		"}\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u00c6\3\2\2\2\u0085\u0086\f\31\2\2"+
		"\u0086\u0087\7!\2\2\u0087\u00c5\5\20\t\32\u0088\u0089\f\30\2\2\u0089\u008a"+
		"\7\37\2\2\u008a\u00c5\5\20\t\31\u008b\u008c\f\27\2\2\u008c\u008d\7 \2"+
		"\2\u008d\u00c5\5\20\t\30\u008e\u008f\f\26\2\2\u008f\u0090\7\36\2\2\u0090"+
		"\u00c5\5\20\t\27\u0091\u0092\f\25\2\2\u0092\u0093\7\34\2\2\u0093\u00c5"+
		"\5\20\t\26\u0094\u0095\f\24\2\2\u0095\u0096\7\35\2\2\u0096\u00c5\5\20"+
		"\t\25\u0097\u0098\f\23\2\2\u0098\u0099\7\20\2\2\u0099\u00c5\5\20\t\24"+
		"\u009a\u009b\f\22\2\2\u009b\u009c\7\17\2\2\u009c\u00c5\5\20\t\23\u009d"+
		"\u009e\f\21\2\2\u009e\u009f\7\21\2\2\u009f\u00c5\5\20\t\22\u00a0\u00a1"+
		"\f\20\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00c5\5\20\t\21\u00a3\u00a4\f\17"+
		"\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00c5\5\20\t\20\u00a6\u00a7\f\r\2\2\u00a7"+
		"\u00a8\7\32\2\2\u00a8\u00c5\5\20\t\16\u00a9\u00aa\f\f\2\2\u00aa\u00ab"+
		"\7\30\2\2\u00ab\u00c5\5\20\t\r\u00ac\u00ad\f\13\2\2\u00ad\u00ae\7\31\2"+
		"\2\u00ae\u00c5\5\20\t\f\u00af\u00b0\f\n\2\2\u00b0\u00b1\7\33\2\2\u00b1"+
		"\u00c5\5\20\t\13\u00b2\u00b3\f\t\2\2\u00b3\u00b4\7\27\2\2\u00b4\u00c5"+
		"\5\20\t\n\u00b5\u00b6\f\b\2\2\u00b6\u00b7\7\16\2\2\u00b7\u00c5\5\20\t"+
		"\t\u00b8\u00b9\f\7\2\2\u00b9\u00ba\7\26\2\2\u00ba\u00c5\5\20\t\b\u00bb"+
		"\u00bc\f\6\2\2\u00bc\u00bd\7\n\2\2\u00bd\u00c5\5\20\t\7\u00be\u00bf\f"+
		"\5\2\2\u00bf\u00c0\7\13\2\2\u00c0\u00c5\5\20\t\6\u00c1\u00c2\f\4\2\2\u00c2"+
		"\u00c3\7\f\2\2\u00c3\u00c5\5\20\t\5\u00c4\u0085\3\2\2\2\u00c4\u0088\3"+
		"\2\2\2\u00c4\u008b\3\2\2\2\u00c4\u008e\3\2\2\2\u00c4\u0091\3\2\2\2\u00c4"+
		"\u0094\3\2\2\2\u00c4\u0097\3\2\2\2\u00c4\u009a\3\2\2\2\u00c4\u009d\3\2"+
		"\2\2\u00c4\u00a0\3\2\2\2\u00c4\u00a3\3\2\2\2\u00c4\u00a6\3\2\2\2\u00c4"+
		"\u00a9\3\2\2\2\u00c4\u00ac\3\2\2\2\u00c4\u00af\3\2\2\2\u00c4\u00b2\3\2"+
		"\2\2\u00c4\u00b5\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4"+
		"\u00be\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\21\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc"+
		"\5\34\17\2\u00ca\u00cb\7\b\2\2\u00cb\u00cd\5\34\17\2\u00cc\u00ca\3\2\2"+
		"\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\7\3\2\2\u00cf\u00d1"+
		"\5\"\22\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2"+
		"\u00d2\u00d3\7\4\2\2\u00d3\23\3\2\2\2\u00d4\u00d5\7\"\2\2\u00d5\u00d6"+
		"\7\3\2\2\u00d6\u00dd\5 \21\2\u00d7\u00d8\7\6\2\2\u00d8\u00db\5 \21\2\u00d9"+
		"\u00da\7\6\2\2\u00da\u00dc\5 \21\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\7\4\2\2\u00e0\25\3\2\2\2\u00e1\u00e3\7%\2\2"+
		"\u00e2\u00e4\5\"\22\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\7&\2\2\u00e6\27\3\2\2\2\u00e7\u00e8\7Q\2\2\u00e8"+
		"\u00ea\7\5\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00f1\7\64\2\2\u00ec\u00ed\7)\2\2\u00ed\u00ee\7\3\2\2\u00ee"+
		"\u00ef\5 \21\2\u00ef\u00f0\7\4\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ec\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\31\3\2\2\2\u00f3\u00f4\7C\2\2\u00f4\u00f5"+
		"\5 \21\2\u00f5\33\3\2\2\2\u00f6\u00f9\5(\25\2\u00f7\u00f9\5\16\b\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\35\3\2\2\2\u00fa\u00fc\7\'\2"+
		"\2\u00fb\u00fd\5\"\22\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\7(\2\2\u00ff\37\3\2\2\2\u0100\u0107\5\4\3\2"+
		"\u0101\u0107\5\20\t\2\u0102\u0103\7\3\2\2\u0103\u0104\5\2\2\2\u0104\u0105"+
		"\7\4\2\2\u0105\u0107\3\2\2\2\u0106\u0100\3\2\2\2\u0106\u0101\3\2\2\2\u0106"+
		"\u0102\3\2\2\2\u0107!\3\2\2\2\u0108\u010d\5 \21\2\u0109\u010a\7\6\2\2"+
		"\u010a\u010c\5 \21\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e#\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7E\2\2\u0111\u0112\7\3\2\2\u0112\u0115\5 \21\2\u0113\u0114\7\6"+
		"\2\2\u0114\u0116\5 \21\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\7\4\2\2\u0118%\3\2\2\2\u0119\u0120\7K\2\2\u011a"+
		"\u0120\7L\2\2\u011b\u0120\7M\2\2\u011c\u0120\7N\2\2\u011d\u0120\7O\2\2"+
		"\u011e\u0120\7P\2\2\u011f\u0119\3\2\2\2\u011f\u011a\3\2\2\2\u011f\u011b"+
		"\3\2\2\2\u011f\u011c\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\'\3\2\2\2\u0121\u0122\7Q\2\2\u0122)\3\2\2\2\34/BJU]enpr\u0081\u0083\u00c4"+
		"\u00c6\u00cc\u00d0\u00db\u00dd\u00e3\u00e9\u00f1\u00f8\u00fc\u0106\u010d"+
		"\u0115\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}