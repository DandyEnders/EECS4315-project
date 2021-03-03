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
	void testLegalLexer()
	{
		String legal = "E X (java.awt.Something)";
		String legal2 = "E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X a.a)";
		String legal3 = "(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.gf && true ) ) )";
		String legal4 = " E X !(A X E X A X E X true && E X !p3.p2)";
		String legal5 = " !E X E X !!!true";
		String legal6 = " ((E X !(A X E X p2.p && !A X p1.d2) && p3.d2) && p1.d2)";
		String legal7 = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.ew)) U !(A X p2.gd && true)))";
		String legal8 = "ひらが.ひらが";
		String legal9 = "cụcCứt.cụcCứt";
		assertEquals(check(legal),true);
		assertEquals(check(legal2),true);
		assertEquals(check(legal3),true);
		assertEquals(check(legal4),true);
		assertEquals(check(legal5),true);
		assertEquals(check(legal6),true);
		assertEquals(check(legal7),true);
		assertEquals(check(legal8),true);
		assertEquals(check(legal9),true);


		
	}
	
	@Test
	void testNotLegalLexerLogic() {
//		assertEquals(check("java.ds G s.d"),false);

//		assertEquals(check("java.sds G"),false);
//		assertEquals(check("F G java.asw"),false);

//		assertEquals(check("java.sds X"),false);
//		assertEquals(check("java.sds F"),false);
		
//		assertEquals(check("G java.sds "),false);
//		assertEquals(check("X java.sds "),false);
//		assertEquals(check("F java.sds "),false);
//		assertEquals(check("G A java.sds "),false);
//		assertEquals(check("X A java.sds "),false);
//		assertEquals(check("F A java.sds "),false);
		
//		assertEquals(check("java.sds <->"),false);
//		assertEquals(check("java.ds X s.d"),false);
//		assertEquals(check("java.ds F s.d"),false);
		
		assertEquals(check("E A java.sds "),false);
		assertEquals(check("A E java.sds "),false);
//		assertEquals(check("java.aws)"),false);
		assertEquals(check("(java.aws"),false);

		
	}
	
	@Test
	void testNotLegalLexerLogic2() {
		assertEquals(check("java.ds && A"),false);
		assertEquals(check("java.sds !! E"),false);
		assertEquals(check("java.sds ! E"),false);
		assertEquals(check("java.sds -> E"),false);
		assertEquals(check("java.sds <-> E"),false);
		
		assertEquals(check("java.ds && "),false);
		assertEquals(check("java.sds !! "),false);
		assertEquals(check("java.sds ! "),false);
		assertEquals(check("java.sds -> "),false);
		assertEquals(check("java.sds <-> "),false);
		
//		assertEquals(check("&& java.ds"),false);
//		assertEquals(check("!! java.sds"),false);
//		assertEquals(check("-> java.sds "),false);
//		assertEquals(check("<-> java.sds "),false);
		
		assertEquals(check("A && java.ds"),false);
		assertEquals(check("A !! java.sds"),false);
		assertEquals(check("A ! java.sds "),false);
		assertEquals(check("A -> java.sds "),false);
		assertEquals(check("A <-> java.sds "),false);
	}

	@Test
	void testAttomicProsition() {
		
		assertEquals(check("java.2"),false);
		assertEquals(check("2ava.a"),false);
		assertEquals(check("2ava.a"),false);
		assertEquals(check("truee"),false);
		assertEquals(check("falsee"),false);
		assertEquals(check("java._"),true);
		assertEquals(check("java._2"),true);
		assertEquals(check("java.ひらが.2ひらが"),false);
	}
	
	
	@Test 
	void testNotLegalJavaName() {
		String notLegal2 = "E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X 2)"; //2 is not valid
		String notLegal3 = "(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.2 && true ) ) )"; //java.2 is not valid
		String notLegal4 = " E X !(A X E X A X E X Truee && E X !p3.p2)"; //truee is not valid
		String notLegal5 = " !EX E X !!!falsee"; //falsee is not valid 
		String notLegal6 = " ((E X !(A X E X p2.p && !A X p1.) && p3.d2) && False)"; //p1. is not
		String notLegal7 = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.2ew)) U !(A X p2.gd && true)))"; //p1.2ew is notvalid
		String notLegal8 = "ひらが.2ひらが";
		String notLegal9 = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.2ew)) U !(A X p2..gd && true)))"; //p1.2ew is notvalid
		assertEquals(check(notLegal2),false);
		assertEquals(check(notLegal3),false);
		assertEquals(check(notLegal4),false);
		assertEquals(check(notLegal5),false);
		assertEquals(check(notLegal6),false);
		assertEquals(check(notLegal7),false);
		assertEquals(check(notLegal8),false);
		assertEquals(check(notLegal9),false);
		
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
		assertEquals(check("M"),false);
//		assertEquals(check(""),false);
//		assertEquals(check("->"),false);
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
		ParseTree tree;
//		parser.setErrorHandler(new ExceptionErrorStrategy());;
		try {
			tree = parser.root();
//			System.out.println((tree.toStringTree()));

		}
		catch (Exception e)
		{
			System.out.println("lol"+e.getMessage());
			return false;
		}
		System.out.println("sd finish "+tree.getText());

		return true;
	}

}