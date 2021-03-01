// Generated from CTL.g4 by ANTLR 4.4
package ctl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, TRUE=3, FALSE=4, E=5, A=6, X=7, U=8, F=9, G=10, WEDGE=11, 
		VEE=12, NEG=13, TO=14, EQUIV=15, ATOMIC_PROPOSITION=16, WS=17;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "TRUE", "FALSE", "'E'", "'A'", "'X'", "'U'", 
		"'F'", "'G'", "'&&'", "'||'", "'!'", "'->'", "'<->'", "ATOMIC_PROPOSITION", 
		"WS"
	};
	public static final int
		RULE_root = 0, RULE_formula = 1;
	public static final String[] ruleNames = {
		"root", "formula"
	};

	@Override
	public String getGrammarFileName() { return "CTL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TRUE) | (1L << FALSE) | (1L << E) | (1L << A) | (1L << NEG) | (1L << ATOMIC_PROPOSITION))) != 0)) {
				{
				{
				setState(4); formula(0);
				}
				}
				setState(9);
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

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public BracketContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitBracket(this);
		}
	}
	public static class ForAllAlwaysContext extends FormulaContext {
		public TerminalNode G() { return getToken(CTLParser.G, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode A() { return getToken(CTLParser.A, 0); }
		public ForAllAlwaysContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterForAllAlways(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitForAllAlways(this);
		}
	}
	public static class OrContext extends FormulaContext {
		public TerminalNode VEE() { return getToken(CTLParser.VEE, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public OrContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitOr(this);
		}
	}
	public static class IffContext extends FormulaContext {
		public TerminalNode EQUIV() { return getToken(CTLParser.EQUIV, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public IffContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitIff(this);
		}
	}
	public static class TrueContext extends FormulaContext {
		public TerminalNode TRUE() { return getToken(CTLParser.TRUE, 0); }
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitTrue(this);
		}
	}
	public static class ExistsEventuallyContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode F() { return getToken(CTLParser.F, 0); }
		public TerminalNode E() { return getToken(CTLParser.E, 0); }
		public ExistsEventuallyContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterExistsEventually(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitExistsEventually(this);
		}
	}
	public static class FalseContext extends FormulaContext {
		public TerminalNode FALSE() { return getToken(CTLParser.FALSE, 0); }
		public FalseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitFalse(this);
		}
	}
	public static class AtomicPropositionContext extends FormulaContext {
		public TerminalNode ATOMIC_PROPOSITION() { return getToken(CTLParser.ATOMIC_PROPOSITION, 0); }
		public AtomicPropositionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterAtomicProposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitAtomicProposition(this);
		}
	}
	public static class ForAllEventuallyContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode F() { return getToken(CTLParser.F, 0); }
		public TerminalNode A() { return getToken(CTLParser.A, 0); }
		public ForAllEventuallyContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterForAllEventually(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitForAllEventually(this);
		}
	}
	public static class NotContext extends FormulaContext {
		public TerminalNode NEG() { return getToken(CTLParser.NEG, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NotContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitNot(this);
		}
	}
	public static class ForAllUntilContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode U() { return getToken(CTLParser.U, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode A() { return getToken(CTLParser.A, 0); }
		public ForAllUntilContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterForAllUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitForAllUntil(this);
		}
	}
	public static class ImpliesContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode TO() { return getToken(CTLParser.TO, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImpliesContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitImplies(this);
		}
	}
	public static class ForAllNextContext extends FormulaContext {
		public TerminalNode X() { return getToken(CTLParser.X, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode A() { return getToken(CTLParser.A, 0); }
		public ForAllNextContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterForAllNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitForAllNext(this);
		}
	}
	public static class AndContext extends FormulaContext {
		public TerminalNode WEDGE() { return getToken(CTLParser.WEDGE, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public AndContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitAnd(this);
		}
	}
	public static class ExistsAlwaysContext extends FormulaContext {
		public TerminalNode G() { return getToken(CTLParser.G, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode E() { return getToken(CTLParser.E, 0); }
		public ExistsAlwaysContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterExistsAlways(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitExistsAlways(this);
		}
	}
	public static class ExistsUntilContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode E() { return getToken(CTLParser.E, 0); }
		public TerminalNode U() { return getToken(CTLParser.U, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ExistsUntilContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterExistsUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitExistsUntil(this);
		}
	}
	public static class ExistsNextContext extends FormulaContext {
		public TerminalNode X() { return getToken(CTLParser.X, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode E() { return getToken(CTLParser.E, 0); }
		public ExistsNextContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterExistsNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitExistsNext(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(11); match(NEG);
				setState(12); formula(16);
				}
				break;
			case 2:
				{
				_localctx = new ForAllNextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13); match(A);
				setState(14); match(X);
				setState(15); formula(12);
				}
				break;
			case 3:
				{
				_localctx = new ForAllEventuallyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16); match(A);
				setState(17); match(F);
				setState(18); formula(11);
				}
				break;
			case 4:
				{
				_localctx = new ForAllAlwaysContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19); match(A);
				setState(20); match(G);
				setState(21); formula(10);
				}
				break;
			case 5:
				{
				_localctx = new ExistsNextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22); match(E);
				setState(23); match(X);
				setState(24); formula(8);
				}
				break;
			case 6:
				{
				_localctx = new ExistsEventuallyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25); match(E);
				setState(26); match(F);
				setState(27); formula(7);
				}
				break;
			case 7:
				{
				_localctx = new ExistsAlwaysContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28); match(E);
				setState(29); match(G);
				setState(30); formula(6);
				}
				break;
			case 8:
				{
				_localctx = new BracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31); match(T__1);
				setState(32); formula(0);
				setState(33); match(T__0);
				}
				break;
			case 9:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35); match(TRUE);
				}
				break;
			case 10:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36); match(FALSE);
				}
				break;
			case 11:
				{
				_localctx = new AtomicPropositionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37); match(ATOMIC_PROPOSITION);
				}
				break;
			case 12:
				{
				_localctx = new ForAllUntilContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38); match(A);
				setState(39); match(T__1);
				setState(40); formula(0);
				setState(41); match(U);
				setState(42); formula(0);
				setState(43); match(T__0);
				}
				break;
			case 13:
				{
				_localctx = new ExistsUntilContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45); match(E);
				setState(46); match(T__1);
				setState(47); formula(0);
				setState(48); match(U);
				setState(49); formula(0);
				setState(50); match(T__0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(54);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(55); match(WEDGE);
						setState(56); formula(5);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(57);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(58); match(VEE);
						setState(59); formula(3);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(60);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(61); match(TO);
						setState(62); formula(2);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(63);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(64); match(EQUIV);
						setState(65); formula(1);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		case 2: return precpred(_ctx, 2);
		case 3: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23J\4\2\t\2\4\3\t"+
		"\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\67"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3E\n\3\f\3\16\3"+
		"H\13\3\3\3\2\3\4\4\2\4\2\2X\2\t\3\2\2\2\4\66\3\2\2\2\6\b\5\4\3\2\7\6\3"+
		"\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3\2\2\2\f"+
		"\r\b\3\1\2\r\16\7\17\2\2\16\67\5\4\3\22\17\20\7\b\2\2\20\21\7\t\2\2\21"+
		"\67\5\4\3\16\22\23\7\b\2\2\23\24\7\13\2\2\24\67\5\4\3\r\25\26\7\b\2\2"+
		"\26\27\7\f\2\2\27\67\5\4\3\f\30\31\7\7\2\2\31\32\7\t\2\2\32\67\5\4\3\n"+
		"\33\34\7\7\2\2\34\35\7\13\2\2\35\67\5\4\3\t\36\37\7\7\2\2\37 \7\f\2\2"+
		" \67\5\4\3\b!\"\7\3\2\2\"#\5\4\3\2#$\7\4\2\2$\67\3\2\2\2%\67\7\5\2\2&"+
		"\67\7\6\2\2\'\67\7\22\2\2()\7\b\2\2)*\7\3\2\2*+\5\4\3\2+,\7\n\2\2,-\5"+
		"\4\3\2-.\7\4\2\2.\67\3\2\2\2/\60\7\7\2\2\60\61\7\3\2\2\61\62\5\4\3\2\62"+
		"\63\7\n\2\2\63\64\5\4\3\2\64\65\7\4\2\2\65\67\3\2\2\2\66\f\3\2\2\2\66"+
		"\17\3\2\2\2\66\22\3\2\2\2\66\25\3\2\2\2\66\30\3\2\2\2\66\33\3\2\2\2\66"+
		"\36\3\2\2\2\66!\3\2\2\2\66%\3\2\2\2\66&\3\2\2\2\66\'\3\2\2\2\66(\3\2\2"+
		"\2\66/\3\2\2\2\67F\3\2\2\289\f\6\2\29:\7\r\2\2:E\5\4\3\7;<\f\5\2\2<=\7"+
		"\16\2\2=E\5\4\3\5>?\f\4\2\2?@\7\20\2\2@E\5\4\3\4AB\f\3\2\2BC\7\21\2\2"+
		"CE\5\4\3\3D8\3\2\2\2D;\3\2\2\2D>\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2G\5\3\2\2\2HF\3\2\2\2\6\t\66DF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}