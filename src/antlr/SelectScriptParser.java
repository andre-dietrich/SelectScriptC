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
		RULE_list = 9, RULE_repo = 10, RULE_set = 11, RULE_stmt = 12, RULE_stmt_list = 13, 
		RULE_value = 14;
	public static final String[] ruleNames = {
		"prog", "assign", "atom", "dict", "dict_elem", "dict_id", "element", "expr", 
		"function", "list", "repo", "set", "stmt", "stmt_list", "value"
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				((ProgContext)_localctx).stmt = stmt();
				((ProgContext)_localctx).elem_.add(((ProgContext)_localctx).stmt);
				setState(31);
				match(END);
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (STRING - 73)) | (1L << (FLOAT - 73)) | (1L << (INTEGER - 73)) | (1L << (TRUE - 73)) | (1L << (FALSE - 73)) | (1L << (NONE - 73)) | (1L << (IDENTIFIER - 73)))) != 0) );
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
		public RepoContext repo_;
		public StmtContext value_;
		public TerminalNode ASSIGN() { return getToken(SelectScriptParser.ASSIGN, 0); }
		public RepoContext repo() {
			return getRuleContext(RepoContext.class,0);
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
			setState(37);
			((AssignContext)_localctx).repo_ = repo();
			setState(38);
			match(ASSIGN);
			setState(39);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public RepoContext repo() {
			return getRuleContext(RepoContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
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
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				repo();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				function();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				dict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				set();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				match(T__0);
				setState(48);
				stmt();
				setState(49);
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
			setState(53);
			match(DICT_BEGIN);
			setState(54);
			((DictContext)_localctx).dict_elem = dict_elem();
			((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(55);
				match(SEP);
				setState(56);
				((DictContext)_localctx).dict_elem = dict_elem();
				((DictContext)_localctx).elem_.add(((DictContext)_localctx).dict_elem);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
			setState(64);
			((Dict_elemContext)_localctx).id_ = dict_id();
			setState(65);
			match(COLON);
			setState(66);
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
			setState(70);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((Dict_idContext)_localctx).str_ = match(STRING);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TerminalNode> LIST_BEGIN() { return getTokens(SelectScriptParser.LIST_BEGIN); }
		public TerminalNode LIST_BEGIN(int i) {
			return getToken(SelectScriptParser.LIST_BEGIN, i);
		}
		public List<Stmt_listContext> stmt_list() {
			return getRuleContexts(Stmt_listContext.class);
		}
		public Stmt_listContext stmt_list(int i) {
			return getRuleContext(Stmt_listContext.class,i);
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
			setState(72);
			atom();
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(83);
				switch (_input.LA(1)) {
				case LIST_BEGIN:
					{
					{
					setState(73);
					match(LIST_BEGIN);
					setState(74);
					stmt_list();
					setState(75);
					match(LIST_END);
					}
					}
					break;
				case DOT:
					{
					setState(79); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(77);
							match(DOT);
							setState(78);
							dict_id();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(81); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT || _la==LIST_BEGIN );
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
			setState(99);
			switch (_input.LA(1)) {
			case MUL:
				{
				_localctx = new Ex_exContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(88);
				match(MUL);
				setState(89);
				((Ex_exContext)_localctx).e1 = expr(27);
				}
				break;
			case NOT:
				{
				_localctx = new Ex_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(NOT);
				setState(91);
				((Ex_notContext)_localctx).e1 = expr(26);
				}
				break;
			case ADD:
				{
				_localctx = new Ex_posContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(ADD);
				setState(93);
				((Ex_posContext)_localctx).e1 = expr(25);
				}
				break;
			case SUB:
				{
				_localctx = new Ex_negContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(SUB);
				setState(95);
				((Ex_negContext)_localctx).e1 = expr(24);
				}
				break;
			case INV:
				{
				_localctx = new Ex_inotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(INV);
				setState(97);
				((Ex_inotContext)_localctx).e1 = expr(12);
				}
				break;
			case T__0:
			case LIST_BEGIN:
			case DICT_BEGIN:
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
				setState(98);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Ex_powContext(new ExprContext(_parentctx, _parentState));
						((Ex_powContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(102);
						match(POW);
						setState(103);
						((Ex_powContext)_localctx).e2 = expr(24);
						}
						break;
					case 2:
						{
						_localctx = new Ex_divContext(new ExprContext(_parentctx, _parentState));
						((Ex_divContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(105);
						match(DIV);
						setState(106);
						((Ex_divContext)_localctx).e2 = expr(23);
						}
						break;
					case 3:
						{
						_localctx = new Ex_modContext(new ExprContext(_parentctx, _parentState));
						((Ex_modContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(108);
						match(MOD);
						setState(109);
						((Ex_modContext)_localctx).e2 = expr(22);
						}
						break;
					case 4:
						{
						_localctx = new Ex_mulContext(new ExprContext(_parentctx, _parentState));
						((Ex_mulContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(111);
						match(MUL);
						setState(112);
						((Ex_mulContext)_localctx).e2 = expr(21);
						}
						break;
					case 5:
						{
						_localctx = new Ex_addContext(new ExprContext(_parentctx, _parentState));
						((Ex_addContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(114);
						match(ADD);
						setState(115);
						((Ex_addContext)_localctx).e2 = expr(20);
						}
						break;
					case 6:
						{
						_localctx = new Ex_subContext(new ExprContext(_parentctx, _parentState));
						((Ex_subContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(117);
						match(SUB);
						setState(118);
						((Ex_subContext)_localctx).e2 = expr(19);
						}
						break;
					case 7:
						{
						_localctx = new Ex_leftContext(new ExprContext(_parentctx, _parentState));
						((Ex_leftContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(120);
						match(SHIFTL);
						setState(121);
						((Ex_leftContext)_localctx).e2 = expr(18);
						}
						break;
					case 8:
						{
						_localctx = new Ex_rightContext(new ExprContext(_parentctx, _parentState));
						((Ex_rightContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(123);
						match(SHIFTR);
						setState(124);
						((Ex_rightContext)_localctx).e2 = expr(17);
						}
						break;
					case 9:
						{
						_localctx = new Ex_iandContext(new ExprContext(_parentctx, _parentState));
						((Ex_iandContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(126);
						match(IAND);
						setState(127);
						((Ex_iandContext)_localctx).e2 = expr(16);
						}
						break;
					case 10:
						{
						_localctx = new Ex_ixorContext(new ExprContext(_parentctx, _parentState));
						((Ex_ixorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(129);
						match(IXOR);
						setState(130);
						((Ex_ixorContext)_localctx).e2 = expr(15);
						}
						break;
					case 11:
						{
						_localctx = new Ex_iorContext(new ExprContext(_parentctx, _parentState));
						((Ex_iorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(132);
						match(IOR);
						setState(133);
						((Ex_iorContext)_localctx).e2 = expr(14);
						}
						break;
					case 12:
						{
						_localctx = new Ex_ltContext(new ExprContext(_parentctx, _parentState));
						((Ex_ltContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(135);
						match(LT);
						setState(136);
						((Ex_ltContext)_localctx).e2 = expr(12);
						}
						break;
					case 13:
						{
						_localctx = new Ex_leContext(new ExprContext(_parentctx, _parentState));
						((Ex_leContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(138);
						match(LE);
						setState(139);
						((Ex_leContext)_localctx).e2 = expr(11);
						}
						break;
					case 14:
						{
						_localctx = new Ex_geContext(new ExprContext(_parentctx, _parentState));
						((Ex_geContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(141);
						match(GE);
						setState(142);
						((Ex_geContext)_localctx).e2 = expr(10);
						}
						break;
					case 15:
						{
						_localctx = new Ex_gtContext(new ExprContext(_parentctx, _parentState));
						((Ex_gtContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(144);
						match(GT);
						setState(145);
						((Ex_gtContext)_localctx).e2 = expr(9);
						}
						break;
					case 16:
						{
						_localctx = new Ex_neContext(new ExprContext(_parentctx, _parentState));
						((Ex_neContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(147);
						match(NE);
						setState(148);
						((Ex_neContext)_localctx).e2 = expr(8);
						}
						break;
					case 17:
						{
						_localctx = new Ex_inContext(new ExprContext(_parentctx, _parentState));
						((Ex_inContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(150);
						match(IN);
						setState(151);
						((Ex_inContext)_localctx).e2 = expr(7);
						}
						break;
					case 18:
						{
						_localctx = new Ex_eqContext(new ExprContext(_parentctx, _parentState));
						((Ex_eqContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(153);
						match(EQ);
						setState(154);
						((Ex_eqContext)_localctx).e2 = expr(6);
						}
						break;
					case 19:
						{
						_localctx = new Ex_andContext(new ExprContext(_parentctx, _parentState));
						((Ex_andContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						match(AND);
						setState(157);
						((Ex_andContext)_localctx).e2 = expr(5);
						}
						break;
					case 20:
						{
						_localctx = new Ex_xorContext(new ExprContext(_parentctx, _parentState));
						((Ex_xorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						match(XOR);
						setState(160);
						((Ex_xorContext)_localctx).e2 = expr(4);
						}
						break;
					case 21:
						{
						_localctx = new Ex_orContext(new ExprContext(_parentctx, _parentState));
						((Ex_orContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(162);
						match(OR);
						setState(163);
						((Ex_orContext)_localctx).e2 = expr(3);
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public RepoContext repo_;
		public Stmt_listContext elem_;
		public RepoContext repo() {
			return getRuleContext(RepoContext.class,0);
		}
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
			setState(169);
			((FunctionContext)_localctx).repo_ = repo();
			setState(170);
			match(T__0);
			setState(172);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (STRING - 73)) | (1L << (FLOAT - 73)) | (1L << (INTEGER - 73)) | (1L << (TRUE - 73)) | (1L << (FALSE - 73)) | (1L << (NONE - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) {
				{
				setState(171);
				((FunctionContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(174);
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
		enterRule(_localctx, 18, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LIST_BEGIN);
			setState(178);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (STRING - 73)) | (1L << (FLOAT - 73)) | (1L << (INTEGER - 73)) | (1L << (TRUE - 73)) | (1L << (FALSE - 73)) | (1L << (NONE - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) {
				{
				setState(177);
				((ListContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(180);
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

	public static class RepoContext extends ParserRuleContext {
		public Token name_;
		public TerminalNode IDENTIFIER() { return getToken(SelectScriptParser.IDENTIFIER, 0); }
		public RepoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectScriptVisitor ) return ((SelectScriptVisitor<? extends T>)visitor).visitRepo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepoContext repo() throws RecognitionException {
		RepoContext _localctx = new RepoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_repo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			((RepoContext)_localctx).name_ = match(IDENTIFIER);
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
		enterRule(_localctx, 22, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(DICT_BEGIN);
			setState(186);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << INV) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << LIST_BEGIN) | (1L << DICT_BEGIN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (STRING - 73)) | (1L << (FLOAT - 73)) | (1L << (INTEGER - 73)) | (1L << (TRUE - 73)) | (1L << (FALSE - 73)) | (1L << (NONE - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) {
				{
				setState(185);
				((SetContext)_localctx).elem_ = stmt_list();
				}
			}

			setState(188);
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
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
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				atom();
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
		enterRule(_localctx, 26, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((Stmt_listContext)_localctx).stmt = stmt();
			((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(196);
				match(SEP);
				setState(197);
				((Stmt_listContext)_localctx).stmt = stmt();
				((Stmt_listContext)_localctx).elem_.add(((Stmt_listContext)_localctx).stmt);
				}
				}
				setState(202);
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
		enterRule(_localctx, 28, RULE_value);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((ValueContext)_localctx).str_ = match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				((ValueContext)_localctx).float_ = match(FLOAT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				((ValueContext)_localctx).int_ = match(INTEGER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				((ValueContext)_localctx).true_ = match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(207);
				((ValueContext)_localctx).false_ = match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(208);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\6\2$\n\2"+
		"\r\2\16\2%\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\66\n\4\3\5\3\5\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\bR\n\b\r\b\16\bS\6\b"+
		"V\n\b\r\b\16\bW\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tf\n"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a7\n\t\f\t\16\t\u00aa"+
		"\13\t\3\n\3\n\3\n\5\n\u00af\n\n\3\n\3\n\3\13\3\13\5\13\u00b5\n\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\5\r\u00bd\n\r\3\r\3\r\3\16\3\16\3\16\5\16\u00c4"+
		"\n\16\3\17\3\17\3\17\7\17\u00c9\n\17\f\17\16\17\u00cc\13\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00d4\n\20\3\20\2\3\20\21\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36\2\2\u00f7\2#\3\2\2\2\4\'\3\2\2\2\6\65\3\2\2\2\b"+
		"\67\3\2\2\2\nB\3\2\2\2\fH\3\2\2\2\16J\3\2\2\2\20e\3\2\2\2\22\u00ab\3\2"+
		"\2\2\24\u00b2\3\2\2\2\26\u00b8\3\2\2\2\30\u00ba\3\2\2\2\32\u00c3\3\2\2"+
		"\2\34\u00c5\3\2\2\2\36\u00d3\3\2\2\2 !\5\32\16\2!\"\7\7\2\2\"$\3\2\2\2"+
		"# \3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'(\5\26\f\2()\7\25"+
		"\2\2)*\5\32\16\2*\5\3\2\2\2+\66\5\36\20\2,\66\5\26\f\2-\66\5\22\n\2.\66"+
		"\5\24\13\2/\66\5\b\5\2\60\66\5\30\r\2\61\62\7\3\2\2\62\63\5\32\16\2\63"+
		"\64\7\4\2\2\64\66\3\2\2\2\65+\3\2\2\2\65,\3\2\2\2\65-\3\2\2\2\65.\3\2"+
		"\2\2\65/\3\2\2\2\65\60\3\2\2\2\65\61\3\2\2\2\66\7\3\2\2\2\678\7\'\2\2"+
		"8=\5\n\6\29:\7\6\2\2:<\5\n\6\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">@\3\2\2\2?=\3\2\2\2@A\7(\2\2A\t\3\2\2\2BC\5\f\7\2CD\7\b\2\2DE\5\32\16"+
		"\2E\13\3\2\2\2FI\7K\2\2GI\7Q\2\2HF\3\2\2\2HG\3\2\2\2I\r\3\2\2\2JU\5\6"+
		"\4\2KL\7%\2\2LM\5\34\17\2MN\7&\2\2NV\3\2\2\2OP\7\5\2\2PR\5\f\7\2QO\3\2"+
		"\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2UK\3\2\2\2UQ\3\2\2\2VW\3\2"+
		"\2\2WU\3\2\2\2WX\3\2\2\2X\17\3\2\2\2YZ\b\t\1\2Z[\7\36\2\2[f\5\20\t\35"+
		"\\]\7\r\2\2]f\5\20\t\34^_\7\34\2\2_f\5\20\t\33`a\7\35\2\2af\5\20\t\32"+
		"bc\7\24\2\2cf\5\20\t\16df\5\6\4\2eY\3\2\2\2e\\\3\2\2\2e^\3\2\2\2e`\3\2"+
		"\2\2eb\3\2\2\2ed\3\2\2\2f\u00a8\3\2\2\2gh\f\31\2\2hi\7!\2\2i\u00a7\5\20"+
		"\t\32jk\f\30\2\2kl\7\37\2\2l\u00a7\5\20\t\31mn\f\27\2\2no\7 \2\2o\u00a7"+
		"\5\20\t\30pq\f\26\2\2qr\7\36\2\2r\u00a7\5\20\t\27st\f\25\2\2tu\7\34\2"+
		"\2u\u00a7\5\20\t\26vw\f\24\2\2wx\7\35\2\2x\u00a7\5\20\t\25yz\f\23\2\2"+
		"z{\7\20\2\2{\u00a7\5\20\t\24|}\f\22\2\2}~\7\17\2\2~\u00a7\5\20\t\23\177"+
		"\u0080\f\21\2\2\u0080\u0081\7\21\2\2\u0081\u00a7\5\20\t\22\u0082\u0083"+
		"\f\20\2\2\u0083\u0084\7\22\2\2\u0084\u00a7\5\20\t\21\u0085\u0086\f\17"+
		"\2\2\u0086\u0087\7\23\2\2\u0087\u00a7\5\20\t\20\u0088\u0089\f\r\2\2\u0089"+
		"\u008a\7\32\2\2\u008a\u00a7\5\20\t\16\u008b\u008c\f\f\2\2\u008c\u008d"+
		"\7\30\2\2\u008d\u00a7\5\20\t\r\u008e\u008f\f\13\2\2\u008f\u0090\7\31\2"+
		"\2\u0090\u00a7\5\20\t\f\u0091\u0092\f\n\2\2\u0092\u0093\7\33\2\2\u0093"+
		"\u00a7\5\20\t\13\u0094\u0095\f\t\2\2\u0095\u0096\7\27\2\2\u0096\u00a7"+
		"\5\20\t\n\u0097\u0098\f\b\2\2\u0098\u0099\7\16\2\2\u0099\u00a7\5\20\t"+
		"\t\u009a\u009b\f\7\2\2\u009b\u009c\7\26\2\2\u009c\u00a7\5\20\t\b\u009d"+
		"\u009e\f\6\2\2\u009e\u009f\7\n\2\2\u009f\u00a7\5\20\t\7\u00a0\u00a1\f"+
		"\5\2\2\u00a1\u00a2\7\13\2\2\u00a2\u00a7\5\20\t\6\u00a3\u00a4\f\4\2\2\u00a4"+
		"\u00a5\7\f\2\2\u00a5\u00a7\5\20\t\5\u00a6g\3\2\2\2\u00a6j\3\2\2\2\u00a6"+
		"m\3\2\2\2\u00a6p\3\2\2\2\u00a6s\3\2\2\2\u00a6v\3\2\2\2\u00a6y\3\2\2\2"+
		"\u00a6|\3\2\2\2\u00a6\177\3\2\2\2\u00a6\u0082\3\2\2\2\u00a6\u0085\3\2"+
		"\2\2\u00a6\u0088\3\2\2\2\u00a6\u008b\3\2\2\2\u00a6\u008e\3\2\2\2\u00a6"+
		"\u0091\3\2\2\2\u00a6\u0094\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u009a\3\2"+
		"\2\2\u00a6\u009d\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\21\3\2\2"+
		"\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ae\7\3\2\2\u00ad"+
		"\u00af\5\34\17\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00b1\7\4\2\2\u00b1\23\3\2\2\2\u00b2\u00b4\7%\2\2\u00b3\u00b5"+
		"\5\34\17\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b7\7&\2\2\u00b7\25\3\2\2\2\u00b8\u00b9\7Q\2\2\u00b9\27\3\2\2"+
		"\2\u00ba\u00bc\7\'\2\2\u00bb\u00bd\5\34\17\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7(\2\2\u00bf\31\3\2\2\2"+
		"\u00c0\u00c4\5\4\3\2\u00c1\u00c4\5\20\t\2\u00c2\u00c4\5\6\4\2\u00c3\u00c0"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\33\3\2\2\2\u00c5"+
		"\u00ca\5\32\16\2\u00c6\u00c7\7\6\2\2\u00c7\u00c9\5\32\16\2\u00c8\u00c6"+
		"\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\35\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00d4\7K\2\2\u00ce\u00d4\7L\2\2"+
		"\u00cf\u00d4\7M\2\2\u00d0\u00d4\7N\2\2\u00d1\u00d4\7O\2\2\u00d2\u00d4"+
		"\7P\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d3"+
		"\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\37\3\2\2"+
		"\2\22%\65=HSUWe\u00a6\u00a8\u00ae\u00b4\u00bc\u00c3\u00ca\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}