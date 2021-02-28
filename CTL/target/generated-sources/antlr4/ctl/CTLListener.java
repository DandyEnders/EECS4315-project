// Generated from CTL.g4 by ANTLR 4.4
package ctl;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CTLParser}.
 */
public interface CTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBracket(@NotNull CTLParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBracket(@NotNull CTLParser.BracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllAlways(@NotNull CTLParser.ForAllAlwaysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllAlways(@NotNull CTLParser.ForAllAlwaysContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull CTLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull CTLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iff}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIff(@NotNull CTLParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iff}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIff(@NotNull CTLParser.IffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTrue(@NotNull CTLParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTrue(@NotNull CTLParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsEventually(@NotNull CTLParser.ExistsEventuallyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsEventually(@NotNull CTLParser.ExistsEventuallyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFalse(@NotNull CTLParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFalse(@NotNull CTLParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicProposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicProposition(@NotNull CTLParser.AtomicPropositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicProposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicProposition(@NotNull CTLParser.AtomicPropositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllEventually(@NotNull CTLParser.ForAllEventuallyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllEventually(@NotNull CTLParser.ForAllEventuallyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull CTLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull CTLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllUntil(@NotNull CTLParser.ForAllUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllUntil(@NotNull CTLParser.ForAllUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull CTLParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull CTLParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllNext(@NotNull CTLParser.ForAllNextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllNext(@NotNull CTLParser.ForAllNextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull CTLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull CTLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link CTLParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull CTLParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link CTLParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull CTLParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsAlways(@NotNull CTLParser.ExistsAlwaysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsAlways(@NotNull CTLParser.ExistsAlwaysContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsUntil(@NotNull CTLParser.ExistsUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsUntil(@NotNull CTLParser.ExistsUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsNext(@NotNull CTLParser.ExistsNextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsNext(@NotNull CTLParser.ExistsNextContext ctx);
}