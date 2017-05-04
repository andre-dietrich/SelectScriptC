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
		DIV=29, MOD=30, POW=31, PIPE=32, IF=33, SQ=34, DQ=35, LIST_BEGIN=36, LIST_END=37, 
		DICT_BEGIN=38, DICT_END=39, PROCEDURE=40, SELECT=41, FROM=42, WHERE=43, 
		ORDER=44, GROUP=45, HAVING=46, BY=47, LIMIT=48, AS=49, LOC=50, CONNECT=51, 
		START=52, STOP=53, WITH=54, NO=55, CYCLE=56, UNIQUE=57, MEMORIZE=58, COST=59, 
		ASC=60, DESC=61, DEL_F=62, MEM_F=63, EVAL_F=64, LOOP=65, EXIT=66, TRY=67, 
		RECUR=68, REF=69, IMPORT=70, NEWLINE=71, WS=72, COMMENT=73, LINE_COMMENT=74, 
		STRING=75, FLOAT=76, INTEGER=77, TRUE=78, FALSE=79, NONE=80, IDENTIFIER=81;
	public static final int
		RULE_prog = 0, RULE_assign = 1, RULE_atom = 2, RULE_dict = 3, RULE_dict_elem = 4, 
		RULE_dict_id = 5, RULE_element = 6, RULE_exit = 7, RULE_expr = 8, RULE_import_s2 = 9, 
		RULE_function = 10, RULE_function_del = 11, RULE_function_mem = 12, RULE_if_expr = 13, 
		RULE_list = 14, RULE_loc = 15, RULE_loop = 16, RULE_pipe = 17, RULE_pipe_allowed = 18, 
		RULE_procedure = 19, RULE_procedure_params = 20, RULE_recur_expr = 21, 
		RULE_reference = 22, RULE_repository = 23, RULE_selection = 24, RULE_sel_as = 25, 
		RULE_sel_connect = 26, RULE_sel_dir = 27, RULE_sel_from = 28, RULE_sel_group = 29, 
		RULE_sel_limit = 30, RULE_sel_list = 31, RULE_sel_order = 32, RULE_sel_select = 33, 
		RULE_sel_start = 34, RULE_sel_stop = 35, RULE_sel_where = 36, RULE_set = 37, 
		RULE_special = 38, RULE_special2 = 39, RULE_stmt = 40, RULE_stmt_list = 41, 
		RULE_try_expr = 42, RULE_value = 43, RULE_variable = 44;
	public static final String[] ruleNames = {
		"prog", "assign", "atom", "dict", "dict_elem", "dict_id", "element", "exit", 
		"expr", "import_s2", "function", "function_del", "function_mem", "if_expr", 
		"list", "loc", "loop", "pipe", "pipe_allowed", "procedure", "procedure_params", 
		"recur_expr", "reference", "repository", "selection", "sel_as", "sel_connect", 
		"sel_dir", "sel_from", "sel_group", "sel_limit", "sel_list", "sel_order", 
		"sel_select", "sel_start", "sel_stop", "sel_where", "set", "special", 
		"special2", "stmt", "stmt_list", "try_expr", "value", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "','", "';'", "':'", "'@'", null, null, null, 
		null, null, "'>>'", "'<<'", "'&'", "'^'", "'|'", "'~'", "'='", "'=='", 
		"'!='", "'<='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'**'", "'|>'", null, "'''", "'\"'", "'['", "']'", "'{'", "'}'", null, 
		null, null, null, null, null, null, null, null, null, "'$'", null, null, 
		null, null, null, null, null, null, null, null, null, "'del'", "'mem'", 
		"'eval'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "DOT", "SEP", "END", "COLON", "AD", "AND", "XOR", "OR", 
		"NOT", "IN", "SHIFTR", "SHIFTL", "IAND", "IXOR", "IOR", "INV", "ASSIGN", 
		"EQ", "NE", "LE", "GE", "LT", "GT", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"POW", "PIPE", "IF", "SQ", "DQ", "LIST_BEGIN", "LIST_END", "DICT_BEGIN", 
		"DICT_END", "PROCEDURE", "SELECT", "FROM", "WHERE", "ORDER", "GROUP", 
		"HAVING", "BY", "LIMIT", "AS", "LOC", "CONNECT", "START", "STOP", "WITH", 
		"NO", "CYCLE", "UNIQUE", "MEMORIZE", "COST", "ASC", "DESC", "DEL_F", "MEM_F", 
		"EVAL_F", "LOOP", "EXIT", "TRY", "RECUR", "REF", "IMPORT", "NEWLINE", 
		"WS", "COMMENT", "LINE_COMMENT", "STRING", "FLOAT", "INTEGER", "TRUE", 
		"FALSE", "NONE", "IDENTIFIER"
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(SelectScriptParser.END); }
		public TerminalNode END(int i) {
			return getToken(SelectScriptParser.END, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(90);
			((ProgContext)_localctx).stmt = stmt();
			((ProgContext)_localctx).elem_.add(((ProgContext)_localctx).stmt);
			}
			{
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					match(END);
					setState(92);
					((ProgContext)_localctx).stmt = stmt();
					((ProgContext)_localctx).elem_.add(((ProgContext)_localctx).stmt);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(99);
			_la = _input.LA(1);
			if (_la==END) {
				{
				setState(98);
				match(END);
				}
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

	public static class AssignContext extends ParserRuleContext {
		public RepositoryContext e1;
		public StmtContext e2;
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
			setState(101);
			((AssignContext)_localctx).e1 = repository();
			setState(102);
			match(ASSIGN);
			setState(103);
			((AssignContext)_localctx).e2 = stmt();
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
		public Recur_exprContext xxx;
		public StmtContext elem_;
		public ProgContext prog_;
		public RepositoryContext repository() {
			return getRuleContext(RepositoryContext.class,0);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public Try_exprContext try_expr() {
			return getRuleContext(Try_exprContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public Recur_exprContext recur_expr() {
			return getRuleContext(Recur_exprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				repository();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				if_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				try_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				loop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				reference();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				((AtomContext)_localctx).xxx = recur_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(111);
				match(T__0);
				setState(112);
				((AtomContext)_localctx).elem_ = stmt();
				setState(113);
				match(T__1);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				match(T__0);
				setState(116);
				((AtomContext)_localctx).prog_ = prog();
				setState(117);
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
			setState(121);
			match(DICT_BEGIN);
			setState(122);
			((DictContext)_localctx).dict_elem = dict_elem();
			((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(123);
				match(SEP);
				setState(124);
				((DictContext)_localctx).dict_elem = dict_elem();
				((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
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
			setState(132);
			((Dict_elemContext)_localctx).id_ = dict_id();
			setState(133);
			match(COLON);
			setState(134);
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
			setState(138);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((Dict_idContext)_localctx).str_ = match(STRING);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
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
			setState(146);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(140);
				((ElementContext)_localctx).var_ = variable();
				}
				break;
			case LOC:
				{
				setState(141);
				((ElementContext)_localctx).loc_ = loc();
				}
				break;
			case T__0:
				{
				setState(142);
				match(T__0);
				setState(143);
				((ElementContext)_localctx).stmt_ = stmt();
				setState(144);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(165); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(165);
					switch (_input.LA(1)) {
					case LIST_BEGIN:
						{
						{
						setState(148);
						match(LIST_BEGIN);
						setState(149);
						stmt();
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==SEP) {
							{
							{
							setState(150);
							match(SEP);
							setState(151);
							stmt();
							}
							}
							setState(156);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(157);
						match(LIST_END);
						}
						}
						break;
					case DOT:
						{
						setState(161); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(159);
								match(DOT);
								setState(160);
								dict_id();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(163); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
				setState(167); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class ExitContext extends ParserRuleContext {
		public StmtContext stmt_;
		public TerminalNode EXIT() { return getToken(SelectScriptParser.EXIT, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitExit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitContext exit() throws RecognitionException {
		ExitContext _localctx = new ExitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(EXIT);
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(170);
				((ExitContext)_localctx).stmt_ = stmt();
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
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public DictContext dict() {
			return getRuleContext(DictContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Ex_elseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_else(this);
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
	public static class Ex_div_mod_mulContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(SelectScriptParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SelectScriptParser.MOD, 0); }
		public TerminalNode MUL() { return getToken(SelectScriptParser.MUL, 0); }
		public Ex_div_mod_mulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_div_mod_mul(this);
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
	public static class Ex_specContext extends ExprContext {
		public SpecialContext special() {
			return getRuleContext(SpecialContext.class,0);
		}
		public Special2Context special2() {
			return getRuleContext(Special2Context.class,0);
		}
		public Ex_specContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_spec(this);
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
	public static class Ex_shiftContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SHIFTL() { return getToken(SelectScriptParser.SHIFTL, 0); }
		public TerminalNode SHIFTR() { return getToken(SelectScriptParser.SHIFTR, 0); }
		public Ex_shiftContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_shift(this);
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
	public static class Ex_add_subContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SelectScriptParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SelectScriptParser.SUB, 0); }
		public Ex_add_subContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitEx_add_sub(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new Ex_specContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176);
				switch (_input.LA(1)) {
				case AND:
				case XOR:
				case OR:
				case IN:
				case SHIFTR:
				case SHIFTL:
				case IAND:
				case IXOR:
				case IOR:
				case EQ:
				case NE:
				case LE:
				case GE:
				case LT:
				case GT:
				case ADD:
				case SUB:
				case MUL:
				case DIV:
				case MOD:
				case POW:
					{
					setState(174);
					special();
					}
					break;
				case T__0:
				case LOC:
				case IDENTIFIER:
					{
					setState(175);
					special2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				_localctx = new Ex_exContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(MUL);
				setState(179);
				((Ex_exContext)_localctx).e1 = expr(23);
				}
				break;
			case 3:
				{
				_localctx = new Ex_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(NOT);
				setState(181);
				((Ex_notContext)_localctx).e1 = expr(22);
				}
				break;
			case 4:
				{
				_localctx = new Ex_posContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(ADD);
				setState(183);
				((Ex_posContext)_localctx).e1 = expr(21);
				}
				break;
			case 5:
				{
				_localctx = new Ex_negContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(SUB);
				setState(185);
				((Ex_negContext)_localctx).e1 = expr(20);
				}
				break;
			case 6:
				{
				_localctx = new Ex_inotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(INV);
				setState(187);
				((Ex_inotContext)_localctx).e1 = expr(12);
				}
				break;
			case 7:
				{
				_localctx = new Ex_elseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(188);
					atom();
					}
					break;
				case 2:
					{
					setState(189);
					value();
					}
					break;
				case 3:
					{
					setState(190);
					list();
					}
					break;
				case 4:
					{
					setState(191);
					dict();
					}
					break;
				case 5:
					{
					setState(192);
					set();
					}
					break;
				case 6:
					{
					setState(193);
					function();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Ex_powContext(new ExprContext(_parentctx, _parentState));
						((Ex_powContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(199);
						match(POW);
						setState(200);
						((Ex_powContext)_localctx).e2 = expr(20);
						}
						break;
					case 2:
						{
						_localctx = new Ex_div_mod_mulContext(new ExprContext(_parentctx, _parentState));
						((Ex_div_mod_mulContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(202);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(203);
						((Ex_div_mod_mulContext)_localctx).e2 = expr(19);
						}
						break;
					case 3:
						{
						_localctx = new Ex_add_subContext(new ExprContext(_parentctx, _parentState));
						((Ex_add_subContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(205);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(206);
						((Ex_add_subContext)_localctx).e2 = expr(18);
						}
						break;
					case 4:
						{
						_localctx = new Ex_shiftContext(new ExprContext(_parentctx, _parentState));
						((Ex_shiftContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(208);
						_la = _input.LA(1);
						if ( !(_la==SHIFTR || _la==SHIFTL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(209);
						((Ex_shiftContext)_localctx).e2 = expr(17);
						}
						break;
					case 5:
						{
						_localctx = new Ex_iandContext(new ExprContext(_parentctx, _parentState));
						((Ex_iandContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(211);
						match(IAND);
						setState(212);
						((Ex_iandContext)_localctx).e2 = expr(16);
						}
						break;
					case 6:
						{
						_localctx = new Ex_ixorContext(new ExprContext(_parentctx, _parentState));
						((Ex_ixorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(214);
						match(IXOR);
						setState(215);
						((Ex_ixorContext)_localctx).e2 = expr(15);
						}
						break;
					case 7:
						{
						_localctx = new Ex_iorContext(new ExprContext(_parentctx, _parentState));
						((Ex_iorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(217);
						match(IOR);
						setState(218);
						((Ex_iorContext)_localctx).e2 = expr(14);
						}
						break;
					case 8:
						{
						_localctx = new Ex_ltContext(new ExprContext(_parentctx, _parentState));
						((Ex_ltContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(220);
						match(LT);
						setState(221);
						((Ex_ltContext)_localctx).e2 = expr(12);
						}
						break;
					case 9:
						{
						_localctx = new Ex_leContext(new ExprContext(_parentctx, _parentState));
						((Ex_leContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(223);
						match(LE);
						setState(224);
						((Ex_leContext)_localctx).e2 = expr(11);
						}
						break;
					case 10:
						{
						_localctx = new Ex_geContext(new ExprContext(_parentctx, _parentState));
						((Ex_geContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(226);
						match(GE);
						setState(227);
						((Ex_geContext)_localctx).e2 = expr(10);
						}
						break;
					case 11:
						{
						_localctx = new Ex_gtContext(new ExprContext(_parentctx, _parentState));
						((Ex_gtContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(229);
						match(GT);
						setState(230);
						((Ex_gtContext)_localctx).e2 = expr(9);
						}
						break;
					case 12:
						{
						_localctx = new Ex_neContext(new ExprContext(_parentctx, _parentState));
						((Ex_neContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(232);
						match(NE);
						setState(233);
						((Ex_neContext)_localctx).e2 = expr(8);
						}
						break;
					case 13:
						{
						_localctx = new Ex_inContext(new ExprContext(_parentctx, _parentState));
						((Ex_inContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(235);
						match(IN);
						setState(236);
						((Ex_inContext)_localctx).e2 = expr(7);
						}
						break;
					case 14:
						{
						_localctx = new Ex_eqContext(new ExprContext(_parentctx, _parentState));
						((Ex_eqContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(238);
						match(EQ);
						setState(239);
						((Ex_eqContext)_localctx).e2 = expr(6);
						}
						break;
					case 15:
						{
						_localctx = new Ex_andContext(new ExprContext(_parentctx, _parentState));
						((Ex_andContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(241);
						match(AND);
						setState(242);
						((Ex_andContext)_localctx).e2 = expr(5);
						}
						break;
					case 16:
						{
						_localctx = new Ex_xorContext(new ExprContext(_parentctx, _parentState));
						((Ex_xorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(244);
						match(XOR);
						setState(245);
						((Ex_xorContext)_localctx).e2 = expr(4);
						}
						break;
					case 17:
						{
						_localctx = new Ex_orContext(new ExprContext(_parentctx, _parentState));
						((Ex_orContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						match(OR);
						setState(248);
						((Ex_orContext)_localctx).e2 = expr(3);
						}
						break;
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class Import_s2Context extends ParserRuleContext {
		public Token file;
		public TerminalNode IMPORT() { return getToken(SelectScriptParser.IMPORT, 0); }
		public TerminalNode STRING() { return getToken(SelectScriptParser.STRING, 0); }
		public Import_s2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_s2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitImport_s2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_s2Context import_s2() throws RecognitionException {
		Import_s2Context _localctx = new Import_s2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_import_s2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(IMPORT);
			setState(255);
			match(T__0);
			setState(256);
			((Import_s2Context)_localctx).file = match(STRING);
			setState(257);
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

	public static class FunctionContext extends ParserRuleContext {
		public Function_delContext del_;
		public Function_memContext mem_;
		public AtomContext repo_;
		public AtomContext extra_;
		public Stmt_listContext elem_;
		public Function_delContext function_del() {
			return getRuleContext(Function_delContext.class,0);
		}
		public Function_memContext function_mem() {
			return getRuleContext(Function_memContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode AD() { return getToken(SelectScriptParser.AD, 0); }
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
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			setState(272);
			switch (_input.LA(1)) {
			case DEL_F:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				((FunctionContext)_localctx).del_ = function_del();
				}
				break;
			case MEM_F:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				((FunctionContext)_localctx).mem_ = function_mem();
				}
				break;
			case T__0:
			case IF:
			case LOC:
			case LOOP:
			case TRY:
			case RECUR:
			case REF:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				((FunctionContext)_localctx).repo_ = atom();
				setState(264);
				_la = _input.LA(1);
				if (_la==AD) {
					{
					setState(262);
					match(AD);
					setState(263);
					((FunctionContext)_localctx).extra_ = atom();
					}
				}

				setState(266);
				match(T__0);
				setState(268);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << AND) | (1L << XOR) | (1L << OR) | (1L << NOT) | (1L << IN) | (1L << SHIFTR) | (1L << SHIFTL) | (1L << IAND) | (1L << IXOR) | (1L << IOR) | (1L << INV) | (1L << EQ) | (1L << NE) | (1L << LE) | (1L << GE) | (1L << LT) | (1L << GT) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << POW) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << PROCEDURE) | (1L << SELECT) | (1L << FROM) | (1L << LOC) | (1L << DEL_F) | (1L << MEM_F))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (EXIT - 65)) | (1L << (TRY - 65)) | (1L << (RECUR - 65)) | (1L << (REF - 65)) | (1L << (IMPORT - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
					{
					setState(267);
					((FunctionContext)_localctx).elem_ = stmt_list();
					}
				}

				setState(270);
				match(T__1);
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

	public static class Function_delContext extends ParserRuleContext {
		public TerminalNode DEL_F() { return getToken(SelectScriptParser.DEL_F, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(SelectScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SelectScriptParser.IDENTIFIER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(SelectScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SelectScriptParser.STRING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(SelectScriptParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SelectScriptParser.SEP, i);
		}
		public Function_delContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_del; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitFunction_del(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_delContext function_del() throws RecognitionException {
		Function_delContext _localctx = new Function_delContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function_del);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(DEL_F);
			setState(275);
			match(T__0);
			setState(284);
			_la = _input.LA(1);
			if (_la==STRING || _la==IDENTIFIER) {
				{
				setState(276);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(277);
					match(SEP);
					setState(278);
					_la = _input.LA(1);
					if ( !(_la==STRING || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(286);
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

	public static class Function_memContext extends ParserRuleContext {
		public TerminalNode MEM_F() { return getToken(SelectScriptParser.MEM_F, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(SelectScriptParser.STRING, 0); }
		public Function_memContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_mem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitFunction_mem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_memContext function_mem() throws RecognitionException {
		Function_memContext _localctx = new Function_memContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_mem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(MEM_F);
			setState(289);
			match(T__0);
			setState(291);
			_la = _input.LA(1);
			if (_la==STRING || _la==IDENTIFIER) {
				{
				setState(290);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(293);
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
		enterRule(_localctx, 26, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(IF);
			setState(296);
			match(T__0);
			setState(297);
			((If_exprContext)_localctx).if_ = stmt();
			setState(304);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(298);
				match(SEP);
				setState(299);
				((If_exprContext)_localctx).then_ = stmt();
				setState(302);
				_la = _input.LA(1);
				if (_la==SEP) {
					{
					setState(300);
					match(SEP);
					setState(301);
					((If_exprContext)_localctx).else_ = stmt();
					}
				}

				}
			}

			setState(306);
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
		enterRule(_localctx, 28, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(LIST_BEGIN);
			setState(310);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << AND) | (1L << XOR) | (1L << OR) | (1L << NOT) | (1L << IN) | (1L << SHIFTR) | (1L << SHIFTL) | (1L << IAND) | (1L << IXOR) | (1L << IOR) | (1L << INV) | (1L << EQ) | (1L << NE) | (1L << LE) | (1L << GE) | (1L << LT) | (1L << GT) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << POW) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << PROCEDURE) | (1L << SELECT) | (1L << FROM) | (1L << LOC) | (1L << DEL_F) | (1L << MEM_F))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (EXIT - 65)) | (1L << (TRY - 65)) | (1L << (RECUR - 65)) | (1L << (REF - 65)) | (1L << (IMPORT - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(309);
				((ListContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(312);
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
		public StmtContext extra_;
		public Token extra2_;
		public Token id_;
		public List<TerminalNode> LOC() { return getTokens(SelectScriptParser.LOC); }
		public TerminalNode LOC(int i) {
			return getToken(SelectScriptParser.LOC, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SelectScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SelectScriptParser.IDENTIFIER, i);
		}
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
		enterRule(_localctx, 30, RULE_loc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(LOC);
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(320);
				switch (_input.LA(1)) {
				case LIST_BEGIN:
					{
					setState(315);
					match(LIST_BEGIN);
					setState(316);
					((LocContext)_localctx).extra_ = stmt();
					setState(317);
					match(LIST_END);
					}
					break;
				case IDENTIFIER:
					{
					setState(319);
					((LocContext)_localctx).extra2_ = match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(322);
				match(LOC);
				}
				break;
			}
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(325);
				((LocContext)_localctx).id_ = match(IDENTIFIER);
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
		enterRule(_localctx, 32, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(LOOP);
			setState(329);
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

	public static class PipeContext extends ParserRuleContext {
		public ExprContext e;
		public Pipe_allowedContext pipe_;
		public Pipe_allowedContext pipe_allowed() {
			return getRuleContext(Pipe_allowedContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitPipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeContext pipe() throws RecognitionException {
		PipeContext _localctx = new PipeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(331);
			((PipeContext)_localctx).e = expr(0);
			}
			setState(332);
			((PipeContext)_localctx).pipe_ = pipe_allowed();
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

	public static class Pipe_allowedContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(SelectScriptParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(SelectScriptParser.PIPE, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<SpecialContext> special() {
			return getRuleContexts(SpecialContext.class);
		}
		public SpecialContext special(int i) {
			return getRuleContext(SpecialContext.class,i);
		}
		public Pipe_allowedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe_allowed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitPipe_allowed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pipe_allowedContext pipe_allowed() throws RecognitionException {
		Pipe_allowedContext _localctx = new Pipe_allowedContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pipe_allowed);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(334);
					match(PIPE);
					setState(337);
					switch (_input.LA(1)) {
					case T__0:
					case IF:
					case LOC:
					case DEL_F:
					case MEM_F:
					case LOOP:
					case TRY:
					case RECUR:
					case REF:
					case IDENTIFIER:
						{
						setState(335);
						function();
						}
						break;
					case AND:
					case XOR:
					case OR:
					case IN:
					case SHIFTR:
					case SHIFTL:
					case IAND:
					case IXOR:
					case IOR:
					case EQ:
					case NE:
					case LE:
					case GE:
					case LT:
					case GT:
					case ADD:
					case SUB:
					case MUL:
					case DIV:
					case MOD:
					case POW:
						{
						setState(336);
						special();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class ProcedureContext extends ParserRuleContext {
		public Procedure_paramsContext params_;
		public Token info_;
		public StmtContext code_;
		public TerminalNode PROCEDURE() { return getToken(SelectScriptParser.PROCEDURE, 0); }
		public TerminalNode COLON() { return getToken(SelectScriptParser.COLON, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Procedure_paramsContext procedure_params() {
			return getRuleContext(Procedure_paramsContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SelectScriptParser.STRING, 0); }
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(PROCEDURE);
			setState(348);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(344);
				match(T__0);
				setState(345);
				((ProcedureContext)_localctx).params_ = procedure_params();
				setState(346);
				match(T__1);
				}
			}

			setState(351);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(350);
				((ProcedureContext)_localctx).info_ = match(STRING);
				}
			}

			setState(353);
			match(COLON);
			setState(354);
			((ProcedureContext)_localctx).code_ = stmt();
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

	public static class Procedure_paramsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SelectScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SelectScriptParser.IDENTIFIER, i);
		}
		public TerminalNode LOC() { return getToken(SelectScriptParser.LOC, 0); }
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
		public Procedure_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitProcedure_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Procedure_paramsContext procedure_params() throws RecognitionException {
		Procedure_paramsContext _localctx = new Procedure_paramsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_procedure_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if (((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & ((1L << (LOC - 50)) | (1L << (STRING - 50)) | (1L << (IDENTIFIER - 50)))) != 0)) {
				{
				setState(359);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(356);
					match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(357);
					match(LOC);
					}
					break;
				case 3:
					{
					setState(358);
					dict_elem();
					}
					break;
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(361);
					match(SEP);
					setState(364);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(362);
						match(IDENTIFIER);
						}
						break;
					case 2:
						{
						setState(363);
						dict_elem();
						}
						break;
					}
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Recur_exprContext extends ParserRuleContext {
		public Stmt_listContext elements_;
		public TerminalNode RECUR() { return getToken(SelectScriptParser.RECUR, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Recur_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recur_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitRecur_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Recur_exprContext recur_expr() throws RecognitionException {
		Recur_exprContext _localctx = new Recur_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_recur_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(RECUR);
			setState(374);
			match(T__0);
			setState(376);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << AND) | (1L << XOR) | (1L << OR) | (1L << NOT) | (1L << IN) | (1L << SHIFTR) | (1L << SHIFTL) | (1L << IAND) | (1L << IXOR) | (1L << IOR) | (1L << INV) | (1L << EQ) | (1L << NE) | (1L << LE) | (1L << GE) | (1L << LT) | (1L << GT) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << POW) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << PROCEDURE) | (1L << SELECT) | (1L << FROM) | (1L << LOC) | (1L << DEL_F) | (1L << MEM_F))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (EXIT - 65)) | (1L << (TRY - 65)) | (1L << (RECUR - 65)) | (1L << (REF - 65)) | (1L << (IMPORT - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(375);
				((Recur_exprContext)_localctx).elements_ = stmt_list();
				}
			}

			setState(378);
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

	public static class ReferenceContext extends ParserRuleContext {
		public AtomContext elem;
		public TerminalNode REF() { return getToken(SelectScriptParser.REF, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(REF);
			setState(381);
			((ReferenceContext)_localctx).elem = atom();
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
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
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
		enterRule(_localctx, 46, RULE_repository);
		try {
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				loc();
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

	public static class SelectionContext extends ParserRuleContext {
		public Sel_selectContext select_;
		public Sel_fromContext from_;
		public Sel_whereContext where_;
		public Sel_startContext start_;
		public Sel_connectContext connect_;
		public Sel_stopContext stop_;
		public Sel_orderContext order_;
		public Sel_groupContext group_;
		public Sel_limitContext limit_;
		public Sel_asContext as_;
		public Sel_fromContext sel_from() {
			return getRuleContext(Sel_fromContext.class,0);
		}
		public Sel_selectContext sel_select() {
			return getRuleContext(Sel_selectContext.class,0);
		}
		public Sel_whereContext sel_where() {
			return getRuleContext(Sel_whereContext.class,0);
		}
		public Sel_startContext sel_start() {
			return getRuleContext(Sel_startContext.class,0);
		}
		public Sel_connectContext sel_connect() {
			return getRuleContext(Sel_connectContext.class,0);
		}
		public Sel_stopContext sel_stop() {
			return getRuleContext(Sel_stopContext.class,0);
		}
		public Sel_orderContext sel_order() {
			return getRuleContext(Sel_orderContext.class,0);
		}
		public Sel_groupContext sel_group() {
			return getRuleContext(Sel_groupContext.class,0);
		}
		public Sel_limitContext sel_limit() {
			return getRuleContext(Sel_limitContext.class,0);
		}
		public Sel_asContext sel_as() {
			return getRuleContext(Sel_asContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(388);
				((SelectionContext)_localctx).select_ = sel_select();
				}
			}

			{
			setState(391);
			((SelectionContext)_localctx).from_ = sel_from();
			}
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(392);
				((SelectionContext)_localctx).where_ = sel_where();
				}
				break;
			}
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(395);
				((SelectionContext)_localctx).start_ = sel_start();
				}
				break;
			}
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(398);
				((SelectionContext)_localctx).connect_ = sel_connect();
				setState(399);
				((SelectionContext)_localctx).stop_ = sel_stop();
				}
				break;
			}
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(403);
				((SelectionContext)_localctx).order_ = sel_order();
				}
				break;
			}
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(406);
				((SelectionContext)_localctx).group_ = sel_group();
				}
				break;
			}
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(409);
				((SelectionContext)_localctx).limit_ = sel_limit();
				}
				break;
			}
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(412);
				((SelectionContext)_localctx).as_ = sel_as();
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

	public static class Sel_asContext extends ParserRuleContext {
		public Stmt_listContext params_;
		public TerminalNode AS() { return getToken(SelectScriptParser.AS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Sel_asContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_as; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_as(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_asContext sel_as() throws RecognitionException {
		Sel_asContext _localctx = new Sel_asContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sel_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(AS);
			setState(416);
			match(IDENTIFIER);
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(417);
				match(T__0);
				setState(418);
				((Sel_asContext)_localctx).params_ = stmt_list();
				setState(419);
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

	public static class Sel_connectContext extends ParserRuleContext {
		public StmtContext mem_;
		public StmtContext cost_;
		public Stmt_listContext elem_;
		public TerminalNode CONNECT() { return getToken(SelectScriptParser.CONNECT, 0); }
		public TerminalNode BY() { return getToken(SelectScriptParser.BY, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode COST() { return getToken(SelectScriptParser.COST, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode NO() { return getToken(SelectScriptParser.NO, 0); }
		public TerminalNode CYCLE() { return getToken(SelectScriptParser.CYCLE, 0); }
		public TerminalNode UNIQUE() { return getToken(SelectScriptParser.UNIQUE, 0); }
		public TerminalNode MEMORIZE() { return getToken(SelectScriptParser.MEMORIZE, 0); }
		public Sel_connectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_connect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_connect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_connectContext sel_connect() throws RecognitionException {
		Sel_connectContext _localctx = new Sel_connectContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sel_connect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(CONNECT);
			setState(424);
			match(BY);
			setState(430);
			switch (_input.LA(1)) {
			case NO:
				{
				{
				setState(425);
				match(NO);
				setState(426);
				match(CYCLE);
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(427);
				match(UNIQUE);
				}
				}
				break;
			case MEMORIZE:
				{
				{
				setState(428);
				match(MEMORIZE);
				setState(429);
				((Sel_connectContext)_localctx).mem_ = stmt();
				}
				}
				break;
			case T__0:
			case AND:
			case XOR:
			case OR:
			case NOT:
			case IN:
			case SHIFTR:
			case SHIFTL:
			case IAND:
			case IXOR:
			case IOR:
			case INV:
			case EQ:
			case NE:
			case LE:
			case GE:
			case LT:
			case GT:
			case ADD:
			case SUB:
			case MUL:
			case DIV:
			case MOD:
			case POW:
			case IF:
			case LIST_BEGIN:
			case DICT_BEGIN:
			case PROCEDURE:
			case SELECT:
			case FROM:
			case LOC:
			case COST:
			case DEL_F:
			case MEM_F:
			case LOOP:
			case EXIT:
			case TRY:
			case RECUR:
			case REF:
			case IMPORT:
			case STRING:
			case FLOAT:
			case INTEGER:
			case TRUE:
			case FALSE:
			case NONE:
			case IDENTIFIER:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(434);
			_la = _input.LA(1);
			if (_la==COST) {
				{
				setState(432);
				match(COST);
				setState(433);
				((Sel_connectContext)_localctx).cost_ = stmt();
				}
			}

			setState(436);
			((Sel_connectContext)_localctx).elem_ = stmt_list();
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

	public static class Sel_dirContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(SelectScriptParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SelectScriptParser.DESC, 0); }
		public Sel_dirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_dir; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_dir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_dirContext sel_dir() throws RecognitionException {
		Sel_dirContext _localctx = new Sel_dirContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_sel_dir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class Sel_fromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SelectScriptParser.FROM, 0); }
		public Sel_listContext sel_list() {
			return getRuleContext(Sel_listContext.class,0);
		}
		public Sel_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_from; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_from(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_fromContext sel_from() throws RecognitionException {
		Sel_fromContext _localctx = new Sel_fromContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sel_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(FROM);
			setState(441);
			sel_list();
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

	public static class Sel_groupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(SelectScriptParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SelectScriptParser.BY, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Sel_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_groupContext sel_group() throws RecognitionException {
		Sel_groupContext _localctx = new Sel_groupContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sel_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(GROUP);
			setState(444);
			match(BY);
			setState(445);
			stmt_list();
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

	public static class Sel_limitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SelectScriptParser.LIMIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Sel_limitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_limit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_limit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_limitContext sel_limit() throws RecognitionException {
		Sel_limitContext _localctx = new Sel_limitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sel_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(LIMIT);
			setState(448);
			expr(0);
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

	public static class Sel_listContext extends ParserRuleContext {
		public List<Dict_elemContext> dict_elem() {
			return getRuleContexts(Dict_elemContext.class);
		}
		public Dict_elemContext dict_elem(int i) {
			return getRuleContext(Dict_elemContext.class,i);
		}
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
		public Sel_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_listContext sel_list() throws RecognitionException {
		Sel_listContext _localctx = new Sel_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_sel_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(450);
				dict_elem();
				}
				break;
			case 2:
				{
				setState(451);
				stmt();
				}
				break;
			}
			setState(461);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(454);
					match(SEP);
					setState(457);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						setState(455);
						dict_elem();
						}
						break;
					case 2:
						{
						setState(456);
						stmt();
						}
						break;
					}
					}
					} 
				}
				setState(463);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	public static class Sel_orderContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SelectScriptParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SelectScriptParser.BY, 0); }
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
		public List<Sel_dirContext> sel_dir() {
			return getRuleContexts(Sel_dirContext.class);
		}
		public Sel_dirContext sel_dir(int i) {
			return getRuleContext(Sel_dirContext.class,i);
		}
		public Sel_orderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_order; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_order(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_orderContext sel_order() throws RecognitionException {
		Sel_orderContext _localctx = new Sel_orderContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sel_order);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(ORDER);
			setState(465);
			match(BY);
			{
			setState(466);
			stmt();
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(467);
				sel_dir();
				}
				break;
			}
			}
			setState(477);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(470);
					match(SEP);
					setState(471);
					stmt();
					setState(473);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						setState(472);
						sel_dir();
						}
						break;
					}
					}
					} 
				}
				setState(479);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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

	public static class Sel_selectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SelectScriptParser.SELECT, 0); }
		public Sel_listContext sel_list() {
			return getRuleContext(Sel_listContext.class,0);
		}
		public Sel_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_select; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_select(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_selectContext sel_select() throws RecognitionException {
		Sel_selectContext _localctx = new Sel_selectContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_sel_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(SELECT);
			setState(481);
			sel_list();
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

	public static class Sel_startContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(SelectScriptParser.START, 0); }
		public TerminalNode WITH() { return getToken(SelectScriptParser.WITH, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Sel_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_startContext sel_start() throws RecognitionException {
		Sel_startContext _localctx = new Sel_startContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sel_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(START);
			setState(484);
			match(WITH);
			setState(485);
			stmt_list();
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

	public static class Sel_stopContext extends ParserRuleContext {
		public TerminalNode STOP() { return getToken(SelectScriptParser.STOP, 0); }
		public TerminalNode WITH() { return getToken(SelectScriptParser.WITH, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Sel_stopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_stop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_stop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_stopContext sel_stop() throws RecognitionException {
		Sel_stopContext _localctx = new Sel_stopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sel_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(STOP);
			setState(488);
			match(WITH);
			setState(489);
			stmt();
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

	public static class Sel_whereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SelectScriptParser.WHERE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Sel_whereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_where; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSel_where(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sel_whereContext sel_where() throws RecognitionException {
		Sel_whereContext _localctx = new Sel_whereContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sel_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(WHERE);
			setState(492);
			stmt();
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
		enterRule(_localctx, 74, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(DICT_BEGIN);
			setState(496);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << AND) | (1L << XOR) | (1L << OR) | (1L << NOT) | (1L << IN) | (1L << SHIFTR) | (1L << SHIFTL) | (1L << IAND) | (1L << IXOR) | (1L << IOR) | (1L << INV) | (1L << EQ) | (1L << NE) | (1L << LE) | (1L << GE) | (1L << LT) | (1L << GT) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << POW) | (1L << IF) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN) | (1L << PROCEDURE) | (1L << SELECT) | (1L << FROM) | (1L << LOC) | (1L << DEL_F) | (1L << MEM_F))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LOOP - 65)) | (1L << (EXIT - 65)) | (1L << (TRY - 65)) | (1L << (RECUR - 65)) | (1L << (REF - 65)) | (1L << (IMPORT - 65)) | (1L << (STRING - 65)) | (1L << (FLOAT - 65)) | (1L << (INTEGER - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NONE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				setState(495);
				((SetContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(498);
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

	public static class SpecialContext extends ParserRuleContext {
		public Stmt_listContext elem_;
		public TerminalNode EQ() { return getToken(SelectScriptParser.EQ, 0); }
		public TerminalNode NE() { return getToken(SelectScriptParser.NE, 0); }
		public TerminalNode LE() { return getToken(SelectScriptParser.LE, 0); }
		public TerminalNode GE() { return getToken(SelectScriptParser.GE, 0); }
		public TerminalNode LT() { return getToken(SelectScriptParser.LT, 0); }
		public TerminalNode GT() { return getToken(SelectScriptParser.GT, 0); }
		public TerminalNode AND() { return getToken(SelectScriptParser.AND, 0); }
		public TerminalNode OR() { return getToken(SelectScriptParser.OR, 0); }
		public TerminalNode XOR() { return getToken(SelectScriptParser.XOR, 0); }
		public TerminalNode ADD() { return getToken(SelectScriptParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SelectScriptParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(SelectScriptParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SelectScriptParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SelectScriptParser.MOD, 0); }
		public TerminalNode POW() { return getToken(SelectScriptParser.POW, 0); }
		public TerminalNode IN() { return getToken(SelectScriptParser.IN, 0); }
		public TerminalNode IOR() { return getToken(SelectScriptParser.IOR, 0); }
		public TerminalNode IAND() { return getToken(SelectScriptParser.IAND, 0); }
		public TerminalNode IXOR() { return getToken(SelectScriptParser.IXOR, 0); }
		public TerminalNode SHIFTR() { return getToken(SelectScriptParser.SHIFTR, 0); }
		public TerminalNode SHIFTL() { return getToken(SelectScriptParser.SHIFTL, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public SpecialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSpecial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialContext special() throws RecognitionException {
		SpecialContext _localctx = new SpecialContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_special);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << XOR) | (1L << OR) | (1L << IN) | (1L << SHIFTR) | (1L << SHIFTL) | (1L << IAND) | (1L << IXOR) | (1L << IOR) | (1L << EQ) | (1L << NE) | (1L << LE) | (1L << GE) | (1L << LT) | (1L << GT) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << POW))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(501);
			match(T__0);
			setState(502);
			((SpecialContext)_localctx).elem_ = stmt_list();
			setState(503);
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

	public static class Special2Context extends ParserRuleContext {
		public RepositoryContext repo_;
		public SpecialContext op_;
		public TerminalNode AD() { return getToken(SelectScriptParser.AD, 0); }
		public RepositoryContext repository() {
			return getRuleContext(RepositoryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SelectScriptParser.NOT, 0); }
		public TerminalNode INV() { return getToken(SelectScriptParser.INV, 0); }
		public TerminalNode ADD() { return getToken(SelectScriptParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SelectScriptParser.SUB, 0); }
		public SpecialContext special() {
			return getRuleContext(SpecialContext.class,0);
		}
		public Special2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitSpecial2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Special2Context special2() throws RecognitionException {
		Special2Context _localctx = new Special2Context(_ctx, getState());
		enterRule(_localctx, 78, RULE_special2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			((Special2Context)_localctx).repo_ = repository();
			setState(506);
			match(AD);
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				{
				setState(507);
				match(NOT);
				setState(508);
				match(T__0);
				setState(509);
				match(T__1);
				}
				}
				break;
			case 2:
				{
				{
				setState(510);
				match(INV);
				setState(511);
				match(T__0);
				setState(512);
				match(T__1);
				}
				}
				break;
			case 3:
				{
				{
				setState(513);
				match(ADD);
				setState(514);
				match(T__0);
				setState(515);
				match(T__1);
				}
				}
				break;
			case 4:
				{
				{
				setState(516);
				match(SUB);
				setState(517);
				match(T__0);
				setState(518);
				match(T__1);
				}
				}
				break;
			case 5:
				{
				{
				setState(519);
				((Special2Context)_localctx).op_ = special();
				}
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

	public static class StmtContext extends ParserRuleContext {
		public ProgContext seq_;
		public Import_s2Context import_s2() {
			return getRuleContext(Import_s2Context.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
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
		enterRule(_localctx, 80, RULE_stmt);
		try {
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				import_s2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				assign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(524);
				pipe();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(525);
				expr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(526);
				procedure();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(527);
				exit();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(528);
				selection();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(529);
				match(T__0);
				setState(530);
				((StmtContext)_localctx).seq_ = prog();
				setState(531);
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
		enterRule(_localctx, 82, RULE_stmt_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			((Stmt_listContext)_localctx).stmt = stmt();
			((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
			setState(540);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(536);
					match(SEP);
					setState(537);
					((Stmt_listContext)_localctx).stmt = stmt();
					((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
					}
					} 
				}
				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		enterRule(_localctx, 84, RULE_try_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(TRY);
			setState(544);
			match(T__0);
			setState(545);
			((Try_exprContext)_localctx).try_ = stmt();
			setState(548);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(546);
				match(SEP);
				setState(547);
				((Try_exprContext)_localctx).catch_ = stmt();
				}
			}

			setState(550);
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
		enterRule(_localctx, 86, RULE_value);
		try {
			setState(558);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				((ValueContext)_localctx).str_ = match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				((ValueContext)_localctx).float_ = match(FLOAT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				((ValueContext)_localctx).int_ = match(INTEGER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(555);
				((ValueContext)_localctx).true_ = match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(556);
				((ValueContext)_localctx).false_ = match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(557);
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
		enterRule(_localctx, 88, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
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
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 4);
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u0235\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\5\2f\n\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4z\n\4\3\5\3\5\3\5\3\5\7\5\u0080\n\5\f\5\16\5\u0083\13\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\5\7\u008d\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0095\n"+
		"\b\3\b\3\b\3\b\3\b\7\b\u009b\n\b\f\b\16\b\u009e\13\b\3\b\3\b\3\b\3\b\6"+
		"\b\u00a4\n\b\r\b\16\b\u00a5\6\b\u00a8\n\b\r\b\16\b\u00a9\3\t\3\t\5\t\u00ae"+
		"\n\t\3\n\3\n\3\n\5\n\u00b3\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\5\n\u00c7\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00fc\n\n\f\n\16\n"+
		"\u00ff\13\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u010b\n\f"+
		"\3\f\3\f\5\f\u010f\n\f\3\f\3\f\5\f\u0113\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u011a"+
		"\n\r\f\r\16\r\u011d\13\r\5\r\u011f\n\r\3\r\3\r\3\16\3\16\3\16\5\16\u0126"+
		"\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0131\n\17\5\17"+
		"\u0133\n\17\3\17\3\17\3\20\3\20\5\20\u0139\n\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0143\n\21\3\21\5\21\u0146\n\21\3\21\5\21\u0149"+
		"\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\5\24\u0154\n\24\6\24"+
		"\u0156\n\24\r\24\16\24\u0157\3\25\3\25\3\25\3\25\3\25\5\25\u015f\n\25"+
		"\3\25\5\25\u0162\n\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u016a\n\26\3"+
		"\26\3\26\3\26\5\26\u016f\n\26\7\26\u0171\n\26\f\26\16\26\u0174\13\26\5"+
		"\26\u0176\n\26\3\27\3\27\3\27\5\27\u017b\n\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\5\31\u0185\n\31\3\32\5\32\u0188\n\32\3\32\3\32\5\32\u018c"+
		"\n\32\3\32\5\32\u018f\n\32\3\32\3\32\3\32\5\32\u0194\n\32\3\32\5\32\u0197"+
		"\n\32\3\32\5\32\u019a\n\32\3\32\5\32\u019d\n\32\3\32\5\32\u01a0\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\5\33\u01a8\n\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u01b1\n\34\3\34\3\34\5\34\u01b5\n\34\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\5!\u01c7\n!\3!\3"+
		"!\3!\5!\u01cc\n!\7!\u01ce\n!\f!\16!\u01d1\13!\3\"\3\"\3\"\3\"\5\"\u01d7"+
		"\n\"\3\"\3\"\3\"\5\"\u01dc\n\"\7\"\u01de\n\"\f\"\16\"\u01e1\13\"\3#\3"+
		"#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\5\'\u01f3\n\'\3\'\3\'\3"+
		"(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u020b\n"+
		")\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0218\n*\3+\3+\3+\7+\u021d\n+\f"+
		"+\16+\u0220\13+\3,\3,\3,\3,\3,\5,\u0227\n,\3,\3,\3-\3-\3-\3-\3-\3-\5-"+
		"\u0231\n-\3.\3.\3.\2\3\22/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\b\3\2\36 \3\2\34\35\3\2\17\20\4"+
		"\2MMSS\3\2>?\5\2\n\f\16\23\26!\u0275\2\\\3\2\2\2\4g\3\2\2\2\6y\3\2\2\2"+
		"\b{\3\2\2\2\n\u0086\3\2\2\2\f\u008c\3\2\2\2\16\u0094\3\2\2\2\20\u00ab"+
		"\3\2\2\2\22\u00c6\3\2\2\2\24\u0100\3\2\2\2\26\u0112\3\2\2\2\30\u0114\3"+
		"\2\2\2\32\u0122\3\2\2\2\34\u0129\3\2\2\2\36\u0136\3\2\2\2 \u013c\3\2\2"+
		"\2\"\u014a\3\2\2\2$\u014d\3\2\2\2&\u0155\3\2\2\2(\u0159\3\2\2\2*\u0175"+
		"\3\2\2\2,\u0177\3\2\2\2.\u017e\3\2\2\2\60\u0184\3\2\2\2\62\u0187\3\2\2"+
		"\2\64\u01a1\3\2\2\2\66\u01a9\3\2\2\28\u01b8\3\2\2\2:\u01ba\3\2\2\2<\u01bd"+
		"\3\2\2\2>\u01c1\3\2\2\2@\u01c6\3\2\2\2B\u01d2\3\2\2\2D\u01e2\3\2\2\2F"+
		"\u01e5\3\2\2\2H\u01e9\3\2\2\2J\u01ed\3\2\2\2L\u01f0\3\2\2\2N\u01f6\3\2"+
		"\2\2P\u01fb\3\2\2\2R\u0217\3\2\2\2T\u0219\3\2\2\2V\u0221\3\2\2\2X\u0230"+
		"\3\2\2\2Z\u0232\3\2\2\2\\a\5R*\2]^\7\7\2\2^`\5R*\2_]\3\2\2\2`c\3\2\2\2"+
		"a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2df\7\7\2\2ed\3\2\2\2ef\3\2\2\2"+
		"f\3\3\2\2\2gh\5\60\31\2hi\7\25\2\2ij\5R*\2j\5\3\2\2\2kz\5\60\31\2lz\5"+
		"\34\17\2mz\5V,\2nz\5\"\22\2oz\5.\30\2pz\5,\27\2qr\7\3\2\2rs\5R*\2st\7"+
		"\4\2\2tz\3\2\2\2uv\7\3\2\2vw\5\2\2\2wx\7\4\2\2xz\3\2\2\2yk\3\2\2\2yl\3"+
		"\2\2\2ym\3\2\2\2yn\3\2\2\2yo\3\2\2\2yp\3\2\2\2yq\3\2\2\2yu\3\2\2\2z\7"+
		"\3\2\2\2{|\7(\2\2|\u0081\5\n\6\2}~\7\6\2\2~\u0080\5\n\6\2\177}\3\2\2\2"+
		"\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7)\2\2\u0085\t\3\2\2\2\u0086"+
		"\u0087\5\f\7\2\u0087\u0088\7\b\2\2\u0088\u0089\5R*\2\u0089\13\3\2\2\2"+
		"\u008a\u008d\7M\2\2\u008b\u008d\7S\2\2\u008c\u008a\3\2\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\r\3\2\2\2\u008e\u0095\5Z.\2\u008f\u0095\5 \21\2\u0090\u0091"+
		"\7\3\2\2\u0091\u0092\5R*\2\u0092\u0093\7\4\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u008e\3\2\2\2\u0094\u008f\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u00a7\3\2"+
		"\2\2\u0096\u0097\7&\2\2\u0097\u009c\5R*\2\u0098\u0099\7\6\2\2\u0099\u009b"+
		"\5R*\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\'"+
		"\2\2\u00a0\u00a8\3\2\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\5\f\7\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u0096\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\17\3\2\2"+
		"\2\u00ab\u00ad\7D\2\2\u00ac\u00ae\5R*\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\21\3\2\2\2\u00af\u00b2\b\n\1\2\u00b0\u00b3\5N(\2\u00b1"+
		"\u00b3\5P)\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00c7\3\2\2"+
		"\2\u00b4\u00b5\7\36\2\2\u00b5\u00c7\5\22\n\31\u00b6\u00b7\7\r\2\2\u00b7"+
		"\u00c7\5\22\n\30\u00b8\u00b9\7\34\2\2\u00b9\u00c7\5\22\n\27\u00ba\u00bb"+
		"\7\35\2\2\u00bb\u00c7\5\22\n\26\u00bc\u00bd\7\24\2\2\u00bd\u00c7\5\22"+
		"\n\16\u00be\u00c5\5\6\4\2\u00bf\u00c5\5X-\2\u00c0\u00c5\5\36\20\2\u00c1"+
		"\u00c5\5\b\5\2\u00c2\u00c5\5L\'\2\u00c3\u00c5\5\26\f\2\u00c4\u00be\3\2"+
		"\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00af\3\2"+
		"\2\2\u00c6\u00b4\3\2\2\2\u00c6\u00b6\3\2\2\2\u00c6\u00b8\3\2\2\2\u00c6"+
		"\u00ba\3\2\2\2\u00c6\u00bc\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00fd\3\2"+
		"\2\2\u00c8\u00c9\f\25\2\2\u00c9\u00ca\7!\2\2\u00ca\u00fc\5\22\n\26\u00cb"+
		"\u00cc\f\24\2\2\u00cc\u00cd\t\2\2\2\u00cd\u00fc\5\22\n\25\u00ce\u00cf"+
		"\f\23\2\2\u00cf\u00d0\t\3\2\2\u00d0\u00fc\5\22\n\24\u00d1\u00d2\f\22\2"+
		"\2\u00d2\u00d3\t\4\2\2\u00d3\u00fc\5\22\n\23\u00d4\u00d5\f\21\2\2\u00d5"+
		"\u00d6\7\21\2\2\u00d6\u00fc\5\22\n\22\u00d7\u00d8\f\20\2\2\u00d8\u00d9"+
		"\7\22\2\2\u00d9\u00fc\5\22\n\21\u00da\u00db\f\17\2\2\u00db\u00dc\7\23"+
		"\2\2\u00dc\u00fc\5\22\n\20\u00dd\u00de\f\r\2\2\u00de\u00df\7\32\2\2\u00df"+
		"\u00fc\5\22\n\16\u00e0\u00e1\f\f\2\2\u00e1\u00e2\7\30\2\2\u00e2\u00fc"+
		"\5\22\n\r\u00e3\u00e4\f\13\2\2\u00e4\u00e5\7\31\2\2\u00e5\u00fc\5\22\n"+
		"\f\u00e6\u00e7\f\n\2\2\u00e7\u00e8\7\33\2\2\u00e8\u00fc\5\22\n\13\u00e9"+
		"\u00ea\f\t\2\2\u00ea\u00eb\7\27\2\2\u00eb\u00fc\5\22\n\n\u00ec\u00ed\f"+
		"\b\2\2\u00ed\u00ee\7\16\2\2\u00ee\u00fc\5\22\n\t\u00ef\u00f0\f\7\2\2\u00f0"+
		"\u00f1\7\26\2\2\u00f1\u00fc\5\22\n\b\u00f2\u00f3\f\6\2\2\u00f3\u00f4\7"+
		"\n\2\2\u00f4\u00fc\5\22\n\7\u00f5\u00f6\f\5\2\2\u00f6\u00f7\7\13\2\2\u00f7"+
		"\u00fc\5\22\n\6\u00f8\u00f9\f\4\2\2\u00f9\u00fa\7\f\2\2\u00fa\u00fc\5"+
		"\22\n\5\u00fb\u00c8\3\2\2\2\u00fb\u00cb\3\2\2\2\u00fb\u00ce\3\2\2\2\u00fb"+
		"\u00d1\3\2\2\2\u00fb\u00d4\3\2\2\2\u00fb\u00d7\3\2\2\2\u00fb\u00da\3\2"+
		"\2\2\u00fb\u00dd\3\2\2\2\u00fb\u00e0\3\2\2\2\u00fb\u00e3\3\2\2\2\u00fb"+
		"\u00e6\3\2\2\2\u00fb\u00e9\3\2\2\2\u00fb\u00ec\3\2\2\2\u00fb\u00ef\3\2"+
		"\2\2\u00fb\u00f2\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fc"+
		"\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\23\3\2\2"+
		"\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7H\2\2\u0101\u0102\7\3\2\2\u0102\u0103"+
		"\7M\2\2\u0103\u0104\7\4\2\2\u0104\25\3\2\2\2\u0105\u0113\5\30\r\2\u0106"+
		"\u0113\5\32\16\2\u0107\u010a\5\6\4\2\u0108\u0109\7\t\2\2\u0109\u010b\5"+
		"\6\4\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010e\7\3\2\2\u010d\u010f\5T+\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2"+
		"\2\u010f\u0110\3\2\2\2\u0110\u0111\7\4\2\2\u0111\u0113\3\2\2\2\u0112\u0105"+
		"\3\2\2\2\u0112\u0106\3\2\2\2\u0112\u0107\3\2\2\2\u0113\27\3\2\2\2\u0114"+
		"\u0115\7@\2\2\u0115\u011e\7\3\2\2\u0116\u011b\t\5\2\2\u0117\u0118\7\6"+
		"\2\2\u0118\u011a\t\5\2\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u0116\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\7\4\2\2\u0121\31\3\2\2\2\u0122\u0123\7A\2\2\u0123\u0125\7\3\2\2"+
		"\u0124\u0126\t\5\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127"+
		"\3\2\2\2\u0127\u0128\7\4\2\2\u0128\33\3\2\2\2\u0129\u012a\7#\2\2\u012a"+
		"\u012b\7\3\2\2\u012b\u0132\5R*\2\u012c\u012d\7\6\2\2\u012d\u0130\5R*\2"+
		"\u012e\u012f\7\6\2\2\u012f\u0131\5R*\2\u0130\u012e\3\2\2\2\u0130\u0131"+
		"\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u012c\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\7\4\2\2\u0135\35\3\2\2\2\u0136\u0138\7&\2\2"+
		"\u0137\u0139\5T+\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a"+
		"\3\2\2\2\u013a\u013b\7\'\2\2\u013b\37\3\2\2\2\u013c\u0145\7\64\2\2\u013d"+
		"\u013e\7&\2\2\u013e\u013f\5R*\2\u013f\u0140\7\'\2\2\u0140\u0143\3\2\2"+
		"\2\u0141\u0143\7S\2\2\u0142\u013d\3\2\2\2\u0142\u0141\3\2\2\2\u0143\u0144"+
		"\3\2\2\2\u0144\u0146\7\64\2\2\u0145\u0142\3\2\2\2\u0145\u0146\3\2\2\2"+
		"\u0146\u0148\3\2\2\2\u0147\u0149\7S\2\2\u0148\u0147\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149!\3\2\2\2\u014a\u014b\7C\2\2\u014b\u014c\5R*\2\u014c#\3"+
		"\2\2\2\u014d\u014e\5\22\n\2\u014e\u014f\5&\24\2\u014f%\3\2\2\2\u0150\u0153"+
		"\7\"\2\2\u0151\u0154\5\26\f\2\u0152\u0154\5N(\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0152\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0150\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\'\3\2\2\2\u0159\u015e"+
		"\7*\2\2\u015a\u015b\7\3\2\2\u015b\u015c\5*\26\2\u015c\u015d\7\4\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u015a\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2"+
		"\2\2\u0160\u0162\7M\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\7\b\2\2\u0164\u0165\5R*\2\u0165)\3\2\2\2\u0166"+
		"\u016a\7S\2\2\u0167\u016a\7\64\2\2\u0168\u016a\5\n\6\2\u0169\u0166\3\2"+
		"\2\2\u0169\u0167\3\2\2\2\u0169\u0168\3\2\2\2\u016a\u0172\3\2\2\2\u016b"+
		"\u016e\7\6\2\2\u016c\u016f\7S\2\2\u016d\u016f\5\n\6\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016d\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016b\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0175\u0169\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"+\3\2\2\2\u0177\u0178\7F\2\2\u0178\u017a\7\3\2\2\u0179\u017b\5T+\2\u017a"+
		"\u0179\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\7\4"+
		"\2\2\u017d-\3\2\2\2\u017e\u017f\7G\2\2\u017f\u0180\5\6\4\2\u0180/\3\2"+
		"\2\2\u0181\u0185\5Z.\2\u0182\u0185\5\16\b\2\u0183\u0185\5 \21\2\u0184"+
		"\u0181\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\61\3\2\2"+
		"\2\u0186\u0188\5D#\2\u0187\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189"+
		"\3\2\2\2\u0189\u018b\5:\36\2\u018a\u018c\5J&\2\u018b\u018a\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u018f\5F$\2\u018e\u018d\3\2\2"+
		"\2\u018e\u018f\3\2\2\2\u018f\u0193\3\2\2\2\u0190\u0191\5\66\34\2\u0191"+
		"\u0192\5H%\2\u0192\u0194\3\2\2\2\u0193\u0190\3\2\2\2\u0193\u0194\3\2\2"+
		"\2\u0194\u0196\3\2\2\2\u0195\u0197\5B\"\2\u0196\u0195\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u019a\5<\37\2\u0199\u0198\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u019d\5> \2\u019c\u019b\3\2\2"+
		"\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u01a0\5\64\33\2\u019f"+
		"\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\63\3\2\2\2\u01a1\u01a2\7\63\2"+
		"\2\u01a2\u01a7\7S\2\2\u01a3\u01a4\7\3\2\2\u01a4\u01a5\5T+\2\u01a5\u01a6"+
		"\7\4\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\65\3\2\2\2\u01a9\u01aa\7\65\2\2\u01aa\u01b0\7\61\2\2\u01ab\u01ac\79\2"+
		"\2\u01ac\u01b1\7:\2\2\u01ad\u01b1\7;\2\2\u01ae\u01af\7<\2\2\u01af\u01b1"+
		"\5R*\2\u01b0\u01ab\3\2\2\2\u01b0\u01ad\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b3\7=\2\2\u01b3\u01b5\5R*"+
		"\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7"+
		"\5T+\2\u01b7\67\3\2\2\2\u01b8\u01b9\t\6\2\2\u01b99\3\2\2\2\u01ba\u01bb"+
		"\7,\2\2\u01bb\u01bc\5@!\2\u01bc;\3\2\2\2\u01bd\u01be\7/\2\2\u01be\u01bf"+
		"\7\61\2\2\u01bf\u01c0\5T+\2\u01c0=\3\2\2\2\u01c1\u01c2\7\62\2\2\u01c2"+
		"\u01c3\5\22\n\2\u01c3?\3\2\2\2\u01c4\u01c7\5\n\6\2\u01c5\u01c7\5R*\2\u01c6"+
		"\u01c4\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c7\u01cf\3\2\2\2\u01c8\u01cb\7\6"+
		"\2\2\u01c9\u01cc\5\n\6\2\u01ca\u01cc\5R*\2\u01cb\u01c9\3\2\2\2\u01cb\u01ca"+
		"\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01c8\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0A\3\2\2\2\u01d1\u01cf\3\2\2\2"+
		"\u01d2\u01d3\7.\2\2\u01d3\u01d4\7\61\2\2\u01d4\u01d6\5R*\2\u01d5\u01d7"+
		"\58\35\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01df\3\2\2\2\u01d8"+
		"\u01d9\7\6\2\2\u01d9\u01db\5R*\2\u01da\u01dc\58\35\2\u01db\u01da\3\2\2"+
		"\2\u01db\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01d8\3\2\2\2\u01de\u01e1"+
		"\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0C\3\2\2\2\u01e1"+
		"\u01df\3\2\2\2\u01e2\u01e3\7+\2\2\u01e3\u01e4\5@!\2\u01e4E\3\2\2\2\u01e5"+
		"\u01e6\7\66\2\2\u01e6\u01e7\78\2\2\u01e7\u01e8\5T+\2\u01e8G\3\2\2\2\u01e9"+
		"\u01ea\7\67\2\2\u01ea\u01eb\78\2\2\u01eb\u01ec\5R*\2\u01ecI\3\2\2\2\u01ed"+
		"\u01ee\7-\2\2\u01ee\u01ef\5R*\2\u01efK\3\2\2\2\u01f0\u01f2\7(\2\2\u01f1"+
		"\u01f3\5T+\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2\2"+
		"\2\u01f4\u01f5\7)\2\2\u01f5M\3\2\2\2\u01f6\u01f7\t\7\2\2\u01f7\u01f8\7"+
		"\3\2\2\u01f8\u01f9\5T+\2\u01f9\u01fa\7\4\2\2\u01faO\3\2\2\2\u01fb\u01fc"+
		"\5\60\31\2\u01fc\u020a\7\t\2\2\u01fd\u01fe\7\r\2\2\u01fe\u01ff\7\3\2\2"+
		"\u01ff\u020b\7\4\2\2\u0200\u0201\7\24\2\2\u0201\u0202\7\3\2\2\u0202\u020b"+
		"\7\4\2\2\u0203\u0204\7\34\2\2\u0204\u0205\7\3\2\2\u0205\u020b\7\4\2\2"+
		"\u0206\u0207\7\35\2\2\u0207\u0208\7\3\2\2\u0208\u020b\7\4\2\2\u0209\u020b"+
		"\5N(\2\u020a\u01fd\3\2\2\2\u020a\u0200\3\2\2\2\u020a\u0203\3\2\2\2\u020a"+
		"\u0206\3\2\2\2\u020a\u0209\3\2\2\2\u020bQ\3\2\2\2\u020c\u0218\5\24\13"+
		"\2\u020d\u0218\5\4\3\2\u020e\u0218\5$\23\2\u020f\u0218\5\22\n\2\u0210"+
		"\u0218\5(\25\2\u0211\u0218\5\20\t\2\u0212\u0218\5\62\32\2\u0213\u0214"+
		"\7\3\2\2\u0214\u0215\5\2\2\2\u0215\u0216\7\4\2\2\u0216\u0218\3\2\2\2\u0217"+
		"\u020c\3\2\2\2\u0217\u020d\3\2\2\2\u0217\u020e\3\2\2\2\u0217\u020f\3\2"+
		"\2\2\u0217\u0210\3\2\2\2\u0217\u0211\3\2\2\2\u0217\u0212\3\2\2\2\u0217"+
		"\u0213\3\2\2\2\u0218S\3\2\2\2\u0219\u021e\5R*\2\u021a\u021b\7\6\2\2\u021b"+
		"\u021d\5R*\2\u021c\u021a\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u021c\3\2\2"+
		"\2\u021e\u021f\3\2\2\2\u021fU\3\2\2\2\u0220\u021e\3\2\2\2\u0221\u0222"+
		"\7E\2\2\u0222\u0223\7\3\2\2\u0223\u0226\5R*\2\u0224\u0225\7\6\2\2\u0225"+
		"\u0227\5R*\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2"+
		"\2\u0228\u0229\7\4\2\2\u0229W\3\2\2\2\u022a\u0231\7M\2\2\u022b\u0231\7"+
		"N\2\2\u022c\u0231\7O\2\2\u022d\u0231\7P\2\2\u022e\u0231\7Q\2\2\u022f\u0231"+
		"\7R\2\2\u0230\u022a\3\2\2\2\u0230\u022b\3\2\2\2\u0230\u022c\3\2\2\2\u0230"+
		"\u022d\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u022f\3\2\2\2\u0231Y\3\2\2\2"+
		"\u0232\u0233\7S\2\2\u0233[\3\2\2\2?aey\u0081\u008c\u0094\u009c\u00a5\u00a7"+
		"\u00a9\u00ad\u00b2\u00c4\u00c6\u00fb\u00fd\u010a\u010e\u0112\u011b\u011e"+
		"\u0125\u0130\u0132\u0138\u0142\u0145\u0148\u0153\u0157\u015e\u0161\u0169"+
		"\u016e\u0172\u0175\u017a\u0184\u0187\u018b\u018e\u0193\u0196\u0199\u019c"+
		"\u019f\u01a7\u01b0\u01b4\u01c6\u01cb\u01cf\u01d6\u01db\u01df\u01f2\u020a"+
		"\u0217\u021e\u0226\u0230";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}