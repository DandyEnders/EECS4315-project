package ctl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;



class TestCTL {
	
	
	public String remove(String f) {
		String formula ="";
		if(f.contains("formula ")) {
			f = f.replaceAll("formula ", "");
			
		}
		if(f.contains("(root ")) {
			f = f.substring(6, f.length() -1);

		}
		return f ;
	}
	
	@Test
	void test() {
		Init init = new Init();
		Lexer lexer = new CTLLexer(CharStreams.fromString(init.TRUE));
		Lexer lexer1 = new CTLLexer(CharStreams.fromString(init.FALSE));
		Lexer lexer2 = new CTLLexer(CharStreams.fromString(init.TRUE + init.AND + init.FALSE));
		Lexer lexer3 = new CTLLexer(CharStreams.fromString(init.TRUE + init.OR + init.FALSE));
		Lexer lexer4 = new CTLLexer(CharStreams.fromString(init.NEG + init.TRUE));
		Lexer lexer5 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IMP + init.TRUE));
		Lexer lexer6 = new CTLLexer(CharStreams.fromString(init.TRUE + init.OR + init.TRUE + init.OR + init.TRUE));
		Lexer lexer7 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IMP + init.TRUE + init.IMP + init.TRUE));
		Lexer lexer8 = new CTLLexer(CharStreams.fromString(init.TRUE + init.AND + init.TRUE + init.AND + init.TRUE));
		Lexer lexer9 = new CTLLexer(CharStreams.fromString(init.TRUE + init.IFF + init.TRUE + init.IFF + init.TRUE));
		Lexer lexer10 = new CTLLexer(CharStreams.fromString(init.LB + init.TRUE + init.AND + init.TRUE + init.RB + init.AND + init.TRUE));
		Lexer lexer11 = new CTLLexer(CharStreams.fromString(init.TRUE + init.AND + init.TRUE + init.AND + init.TRUE));
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(tokens);
		ParseTree tree = parser.root();	
		//System.out.println(tree.toStringTree());
		assertEquals(init.TRUE, tree.getText());
		
		CommonTokenStream token1 = new CommonTokenStream(lexer1);
		CTLParser parser1 = new CTLParser(token1);
		ParseTree tree1 = parser1.root();
		assertEquals(init.FALSE, tree1.getText());
		             
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
		
		CommonTokenStream token8 = new CommonTokenStream(lexer8);
		CTLParser parser8 = new CTLParser(token8);
		ParseTree tree8 = parser8.root();
		
		CommonTokenStream token9 = new CommonTokenStream(lexer9);
		CTLParser parser9 = new CTLParser(token9);
		ParseTree tree9 = parser9.root();
		
		CommonTokenStream token10 = new CommonTokenStream(lexer10);
		CTLParser parser10 = new CTLParser(token10);
		ParseTree tree10 = parser10.root();
		
		//  <-----Testing all the formulas----->
		
		// Testing true
		String f = remove(tree.toStringTree(parser));
		assertEquals("(true)", f);
		
		// Testing false
		String f1 = remove(tree1.toStringTree(parser1));
		assertEquals("(false)", f1);
		
		//Testing True && false
		String f2 = remove(tree2.toStringTree(parser2));
		assertEquals("((true) && (false))", f2);
		
		//Testing True || false
		String f3 = remove(tree3.toStringTree(parser3));
		assertEquals("((true) || (false))", f3);
		
		//Testing negation
		String f4 = remove(tree4.toStringTree(parser4));
		assertEquals("(! (true))", f4);
		
		
		//Testing implies
		String f5 = remove(tree5.toStringTree(parser5));
		assertEquals("((true) -> (true))", f5);
		
		//Testing Associativity of OR
		String f6 = remove(tree6.toStringTree(parser6));
		assertEquals("((true) || ((true) || (true)))", f6);
		
		//Testing Associativity of IMPLIES
		String f7 = remove(tree7.toStringTree(parser7));
		assertEquals("((true) -> ((true) -> (true)))", f7);
		
		//Testing Associativity of AND
		String f8 = remove(tree8.toStringTree(parser8));
		assertEquals("(((true) && (true)) && (true))", f8);
		
		//Testing Associativity of Equivalence
		String f9 = remove(tree9.toStringTree(parser9));
		assertEquals("((true) <-> ((true) <-> (true)))", f9);
		
		String f10 = remove(tree10.toStringTree(parser10));
		assertEquals("((( ((true) && (true)) )) && (true))", f10);
	}
	@Test
	void testLegalLexer()
	{
		String legal = "E X (java.awt.Something)";
		String legal2 = "E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X a.a)";
		String legal3 = "(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.gf && true ) ) )";
		String legal4 = " E X !(A X E X A X E X true && E X !p3.p2)";
		String legal5 = " !E X E X !!!true";
		String legal6 = " ((E X !(A X E X p2.p && !A X p1.d2) && p3.d2) && p1.d2)";
		String legal7 = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.ew)) U !(A X p2.gd && true)))";
		assertEquals(check(legal),true);
		assertEquals(check(legal2),true);
		assertEquals(check(legal3),true);
		assertEquals(check(legal4),true);
		assertEquals(check(legal5),true);
		assertEquals(check(legal6),true);
		assertEquals(check(legal7),true);

		
	}
	@Test
	void testNotLegalLexerLogic() {}
	@Test
	void testNotLegalLexerJavaName() {}
	@Test
	void testNotLegalLexerspecialChar() {
		String notLegal2 = "E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X 2)";
		String notLegal3 = "(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.2 && true ) ) )";
		String notLegal4 = " E X !(A X E X A X E X Truee && E X !p3.p2)";
		String notLegal5 = " !EX E X !!!truee";
		String notLegal6 = " ((E X !(A X E X p2.p && !A X p1.) && p3.d2) && False)";
		String notLegal7 = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.2ew)) U !(A X p2.gd && true)))";
		assertEquals(check(notLegal2),false);
		assertEquals(check(notLegal3),false);
		assertEquals(check(notLegal4),false);
		assertEquals(check(notLegal5),false);
		assertEquals(check(notLegal6),false);
		assertEquals(check(notLegal7),false);
		
	}
	@Test
	void testNotLegalLexerBasic()
	{
		String notLegal = "E X W (java.awt.Something)";
		assertEquals(check(notLegal),false);
		assertEquals(check("E E E A A <-> java.java"),false);
		assertEquals(check("E E"),false);
		assertEquals(check("E A"),false);
		assertEquals(check("A"),false);	
		assertEquals(check("E"),false);
		assertEquals(check("->"),false);
	}
	
	boolean check(String s)
	{
		Lexer l1 = new CTLLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(l1);
		CTLParser parser = new CTLParser(tokens);
		
		l1.removeErrorListeners();
		l1.addErrorListener(DescriptiveErrorListener.INSTANCE);
		parser.removeErrorListeners();
		parser.addErrorListener(DescriptiveErrorListener.INSTANCE);

		try {
			ParseTree tree = parser.root();
//			System.out.println(tree.toStringTree(parser));

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}