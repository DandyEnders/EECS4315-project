package ctl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
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

}
