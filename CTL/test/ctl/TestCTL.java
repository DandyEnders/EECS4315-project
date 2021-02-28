package ctl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

class TestCTL {

	public String remove(String f) {
		String formula = "";
		if (f.contains("formula ")) {
			f = f.replaceAll("formula ", "");

		}
		if (f.contains("(root ")) {
			f = f.substring(6, f.length() - 1);

		}
		return f;
	}

	@Test
	void testInitial() {
		Init init = new Init();
		Lexer lexer = new CTLLexer(CharStreams.fromString(init.TRUE));
		Lexer lexer1 = new CTLLexer(CharStreams.fromString(init.FALSE));

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(tokens);
		ParseTree tree = parser.root();

		CommonTokenStream token1 = new CommonTokenStream(lexer1);
		CTLParser parser1 = new CTLParser(token1);
		ParseTree tree1 = parser1.root();

		// Testing true
		String f = remove(tree.toStringTree(parser));
		assertEquals("(true)", f);

		// Testing false
		String f1 = remove(tree1.toStringTree(parser1));
		assertEquals("(false)", f1);

	}

	@Test
	void testConnectives() {
		Init init = new Init();
		Lexer lexer2 = new CTLLexer(CharStreams.fromString(init.TRUE + init.AND + init.FALSE));
		Lexer lexer3 = new CTLLexer(CharStreams.fromString(init.TRUE + init.OR + init.FALSE));
		Lexer lexer4 = new CTLLexer(CharStreams.fromString(init.NEG + init.TRUE));
		Lexer lexer5 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IMP + init.TRUE));
		Lexer lexer10 = new CTLLexer(
				CharStreams.fromString(init.LB + init.TRUE + init.AND + init.TRUE + init.RB + init.AND + init.TRUE));
		Lexer lexer11 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IFF + init.FALSE));
		Lexer lexer12 = new CTLLexer(CharStreams.fromString(init.EX + init.NEXT + init.TRUE + init.OR + init.FALSE));
		Lexer lexer13 = new CTLLexer(CharStreams.fromString(init.FA + init.TRUE + init.U + init.FALSE));
		Lexer lexer14 = new CTLLexer(CharStreams.fromString(init.EX + init.EVENT + init.TRUE + init.AND + init.TRUE));
		Lexer lexer15 = new CTLLexer(CharStreams.fromString(init.FA + init.ALWAYS + init.TRUE));

		CommonTokenStream token2 = new CommonTokenStream(lexer2);
		CTLParser parser2 = new CTLParser(token2);
		ParseTree tree2 = parser2.root();

		CommonTokenStream token3 = new CommonTokenStream(lexer3);
		CTLParser parser3 = new CTLParser(token3);
		ParseTree tree3 = parser3.root();

		CommonTokenStream token4 = new CommonTokenStream(lexer4);
		CTLParser parser4 = new CTLParser(token4);
		ParseTree tree4 = parser4.root();

		CommonTokenStream token5 = new CommonTokenStream(lexer5);
		CTLParser parser5 = new CTLParser(token5);
		ParseTree tree5 = parser5.root();

		CommonTokenStream token10 = new CommonTokenStream(lexer10);
		CTLParser parser10 = new CTLParser(token10);
		ParseTree tree10 = parser10.root();

		CommonTokenStream token11 = new CommonTokenStream(lexer11);
		CTLParser parser11 = new CTLParser(token11);
		ParseTree tree11 = parser11.root();

		CommonTokenStream token12 = new CommonTokenStream(lexer12);
		CTLParser parser12 = new CTLParser(token12);
		ParseTree tree12 = parser12.root();

		CommonTokenStream token13 = new CommonTokenStream(lexer13);
		CTLParser parser13 = new CTLParser(token13);
		ParseTree tree13 = parser13.root();

		CommonTokenStream token14 = new CommonTokenStream(lexer14);
		CTLParser parser14 = new CTLParser(token14);
		ParseTree tree14 = parser14.root();

		CommonTokenStream token15 = new CommonTokenStream(lexer15);
		CTLParser parser15 = new CTLParser(token15);
		ParseTree tree15 = parser15.root();

		// Testing True with AND, false
		String f2 = remove(tree2.toStringTree(parser2));
		assertEquals("((true) && (false))", f2);

		// Testing True || false
		String f3 = remove(tree3.toStringTree(parser3));
		assertEquals("((true) || (false))", f3);

		// Testing negation
		String f4 = remove(tree4.toStringTree(parser4));
		assertEquals("(! (true))", f4);

		// Testing implies
		String f5 = remove(tree5.toStringTree(parser5));
		assertEquals("((true) -> (true))", f5);

		// Testing Bracket in conjunction with AND, true
		String f10 = remove(tree10.toStringTree(parser10));
		assertEquals("((( ((true) && (true)) )) && (true))", f10);

		// Testing equivalence
		String f11 = remove(tree11.toStringTree(parser11));
		assertEquals("((true) <-> (false))", f11);

		// Testing Exists, next with OR, true, false
		String f12 = remove(tree12.toStringTree(parser12));
		assertEquals("((E X (true)) || (false))", f12);

		// Testing For all, until with true,false
		String f13 = remove(tree13.toStringTree(parser13));
		assertEquals("(A (true) U (false))", f13);

		// Testing Exists, eventually with AND, true
		String f14 = remove(tree14.toStringTree(parser14));
		assertEquals("((E F (true)) && (true))", f14);

		// Testing Forall, ALWAYS with true
		String f15 = remove(tree15.toStringTree(parser15));
		assertEquals("(A G (true))", f15);

	}

	@Test
	void testAssociativity() {
		Init init = new Init();
		Lexer lexer1 = new CTLLexer(CharStreams.fromString(init.TRUE + init.OR + init.TRUE + init.OR + init.TRUE));
		Lexer lexer2 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IMP + init.TRUE + init.IMP + init.TRUE));
		Lexer lexer3 = new CTLLexer(CharStreams.fromString(init.TRUE + init.AND + init.TRUE + init.AND + init.TRUE));
		Lexer lexer4 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IFF + init.TRUE + init.IFF + init.TRUE));
		Lexer lexer5 = new CTLLexer(CharStreams.fromString(init.FA + init.U + init.TRUE));
		Lexer lexer6 = new CTLLexer(CharStreams.fromString(init.EX + init.U + init.FALSE));

		CommonTokenStream token1 = new CommonTokenStream(lexer1);
		CTLParser parser1 = new CTLParser(token1);
		ParseTree tree1 = parser1.root();

		CommonTokenStream token2 = new CommonTokenStream(lexer2);
		CTLParser parser2 = new CTLParser(token2);
		ParseTree tree2 = parser2.root();

		CommonTokenStream token3 = new CommonTokenStream(lexer3);
		CTLParser parser3 = new CTLParser(token3);
		ParseTree tree3 = parser3.root();

		CommonTokenStream token4 = new CommonTokenStream(lexer4);
		CTLParser parser4 = new CTLParser(token4);
		ParseTree tree4 = parser4.root();

		CommonTokenStream token5 = new CommonTokenStream(lexer5);
		CTLParser parser5 = new CTLParser(token5);
		ParseTree tree5 = parser5.root();

		CommonTokenStream token6 = new CommonTokenStream(lexer6);
		CTLParser parser6 = new CTLParser(token6);
		ParseTree tree6 = parser6.root();

		// Testing Associativity of OR
		String f1 = remove(tree1.toStringTree(parser1));
		assertEquals("((true) || ((true) || (true)))", f1);

		// Testing Associativity of IMPLIES
		String f2 = remove(tree2.toStringTree(parser2));
		assertEquals("((true) -> ((true) -> (true)))", f2);

		// Testing Associativity of AND
		String f3 = remove(tree3.toStringTree(parser3));
		assertEquals("(((true) && (true)) && (true))", f3);

		// Testing Associativity of Equivalence
		String f4 = remove(tree4.toStringTree(parser4));
		assertEquals("((true) <-> ((true) <-> (true)))", f4);

		// Testing Forall Until, true
		String f5 = remove(tree5.toStringTree(parser5));
		assertEquals("(A U) (true)", f5);

		// Testing Exist Until, false
		String f6 = remove(tree6.toStringTree(parser6));
		assertEquals("(E U) (false)", f6);

	}

	@Test
	void testPrecedance() {
		Init init = new Init();
		Lexer lexer1 = new CTLLexer(
				CharStreams.fromString(init.LB + init.TRUE + init.AND + init.FALSE + init.OR + init.TRUE + init.RB));
		Lexer lexer2 = new CTLLexer(CharStreams.fromString(init.FA + init.NEXT + init.TRUE));
		Lexer lexer3 = new CTLLexer(CharStreams.fromString(init.FA + init.NEXT + init.EX + init.NEXT + init.TRUE));
		Lexer lexer4 = new CTLLexer(
				CharStreams.fromString(init.FA + init.EVENT + init.EX + init.EVENT + init.NEG + init.FALSE));
		Lexer lexer5 = new CTLLexer(CharStreams.fromString(init.FA + init.EX + init.TRUE + init.U + init.FALSE));
		Lexer lexer6 = new CTLLexer(
				CharStreams.fromString(init.EX + init.LB + init.EX + init.NEXT + init.TRUE + init.RB));
		Lexer lexer7 = new CTLLexer(CharStreams.fromString(init.EX + init.NEXT + init.FA + init.NEXT + init.TRUE));

		CommonTokenStream token1 = new CommonTokenStream(lexer1);
		CTLParser parser1 = new CTLParser(token1);
		ParseTree tree1 = parser1.root();

		CommonTokenStream token2 = new CommonTokenStream(lexer2);
		CTLParser parser2 = new CTLParser(token2);
		ParseTree tree2 = parser2.root();

		CommonTokenStream token3 = new CommonTokenStream(lexer3);
		CTLParser parser3 = new CTLParser(token3);
		ParseTree tree3 = parser3.root();

		CommonTokenStream token4 = new CommonTokenStream(lexer4);
		CTLParser parser4 = new CTLParser(token4);
		ParseTree tree4 = parser4.root();

		CommonTokenStream token5 = new CommonTokenStream(lexer5);
		CTLParser parser5 = new CTLParser(token5);
		ParseTree tree5 = parser5.root();

		CommonTokenStream token6 = new CommonTokenStream(lexer6);
		CTLParser parser6 = new CTLParser(token6);
		ParseTree tree6 = parser6.root();

		CommonTokenStream token7 = new CommonTokenStream(lexer7);
		CTLParser parser7 = new CTLParser(token7);
		ParseTree tree7 = parser7.root();

		// Testing AND in conjunction with OR with brackets
		String f1 = remove(tree1.toStringTree(parser1));
		assertEquals("(( (((true) && (false)) || (true)) ))", f1);

		// Testing For all Next TRUE
		String f2 = remove(tree2.toStringTree(parser2));
		assertEquals("(A X (true))", f2);

		// Testing For all Next Exists Next TRUE
		String f3 = remove(tree3.toStringTree(parser3));
		assertEquals("(A X (E X (true)))", f3);

		// Testing For all Eventually Exists Eventually Negation FALSE
		String f4 = remove(tree4.toStringTree(parser4));
		assertEquals("(A F (E F (! (false))))", f4);

		// Testing For all Exists TRUE Until FALSE
		String f5 = remove(tree5.toStringTree(parser5));
		assertEquals("(A (E (true) U (false)))", f5);

		// Testing Exists Exists next true with brackets
		String f6 = remove(tree6.toStringTree(parser6));
		assertEquals("(E (( (E X (true)) )))", f6);

		// Testing Exists Next For all Next TRUE
		String f7 = remove(tree7.toStringTree(parser7));
		assertEquals("(E X (A X (true)))", f7);

	}

}
