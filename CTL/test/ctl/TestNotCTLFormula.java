package ctl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import util.TestingTemplate;

public class TestNotCTLFormula extends TestingTemplate {
	
	@Test
	public void testLegalLexer1() {
		String legal = "E X (java.awt.Something)";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer2() {
		String legal = "E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X a.a)";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer3() {
		String legal = "(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.gf && true ) ) )";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer4() {
		String legal = " E X !(A X E X A X E X true && E X !p3.p2)";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer5() {
		String legal = " !E X E X !!!true";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer6() {
		String legal = " ((E X !(A X E X p2.p && !A X p1.d2) && p3.d2) && p1.d2)";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer7() {
		String legal = " (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.ew)) U !(A X p2.gd && true)))";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer8() {
		String legal = "ひらが.ひらが";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer9() {
		String legal = "cụcCứt.cụcCứt";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testLegalLexer10() {
		String legal = "자바.클래스.필드";
		assertTrue(checkSyntaxError(legal));
	}
	
	@Test
	public void testIllegalToken1() {
		assertFalse(checkSyntaxError("E A java.sds "));
	}
	
	@Test
	public void testIllegalToken2() {
		assertFalse(checkSyntaxError("A E java.sds "));
	}
	
	@Test
	public void testIllegalToken3() {
		assertFalse(checkSyntaxError("java.ds && A"));
	}
	
	@Test
	public void testIllegalToken4() {
		assertFalse(checkSyntaxError("java.sds !! E"));
	}
	
	@Test
	public void testIllegalToken5() {
		assertFalse(checkSyntaxError("java.sds ! E"));
	}
	
	@Test
	public void testIllegalToken6() {
		assertFalse(checkSyntaxError("java.sds -> E"));
	}
	
	@Test
	public void testIllegalToken7() {
		assertFalse(checkSyntaxError("java.sds <-> E"));
	}
	
	@Test
	public void testIllegalToken8() {
		assertFalse(checkSyntaxError("java.ds && "));
	}
	
	@Test
	public void testIllegalToken9() {
		assertFalse(checkSyntaxError("java.sds !! "));
	}
	
	@Test
	public void testIllegalToken10() {
		assertFalse(checkSyntaxError("java.sds ! "));
	}
	
	@Test
	public void testIllegalToken11() {
		assertFalse(checkSyntaxError("java.sds -> "));
	}
	
	@Test
	public void testIllegalToken12() {
		assertFalse(checkSyntaxError("java.sds <-> "));
	}
	
	@Test
	public void testIllegalToken13() {
		assertFalse(checkSyntaxError("A && java.ds"));
	}
	
	@Test
	public void testIllegalToken14() {
		assertFalse(checkSyntaxError("A !! java.sds"));
	}
	
	@Test
	public void testIllegalToken15() {
		assertFalse(checkSyntaxError("A ! java.sds "));
	}
	
	@Test
	public void testIllegalToken16() {
		assertFalse(checkSyntaxError("A -> java.sds "));
	}
	
	@Test
	public void testIllegalToken17() {
		assertFalse(checkSyntaxError("A <-> java.sds "));
	}
	
	@Test
	public void testIllegalToken18() {
		assertFalse(checkSyntaxError("java.2"));
	}
	
	@Test
	public void testIllegalToken19() {
		assertFalse(checkSyntaxError("2ava.a"));
	}
	
	@Test
	public void testIllegalToken20() {
		assertFalse(checkSyntaxError("truee"));
	}
	
	@Test
	public void testIllegalToken21() {
		assertFalse(checkSyntaxError("falsee"));
	}
	
	@Ignore("Refer to section 5.1.2 on the report.")
	@Test
	public void testIllegalToken22() {
		assertFalse(checkSyntaxError("java._"));
	}
	
	@Ignore("Refer to section 5.1.2 on the report.")
	@Test
	public void testIllegalToken23() {
		assertFalse(checkSyntaxError("java._2"));
	}
	
	@Test
	public void testIllegalToken24() {
		assertFalse(checkSyntaxError("E X java.powe.asd && E X java.java.java.java.java -> (E X a.a) && (E X 2)"));
	}
	
	@Test
	public void testIllegalToken25() {
		assertFalse(checkSyntaxError("(true && A((E(E(java.java U java.jav ) U A X java.ka ) && E ( ! java.d U java.ds ) ) U ! ( A X java.2 && true ) ) )"));
	}
	
	@Test
	public void testIllegalToken26() {
		assertFalse(checkSyntaxError(" E X !(A X E X A X E X Truee && E X !p3.p2)"));
	}
	
	@Test
	public void testIllegalToken27() {
		assertFalse(checkSyntaxError(" !EX E X !!!falsee"));
	}
	
	@Test
	public void testIllegalToken28() {
		assertFalse(checkSyntaxError(" ((E X !(A X E X p2.p && !A X p1.) && p3.d2) && False)"));
	}
	
	@Test
	public void testIllegalToken29() {
		assertFalse(checkSyntaxError(" (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.2ew)) U !(A X p2.gd && true)))"));
	}
	
	@Test
	public void testIllegalToken30() {
		assertFalse(checkSyntaxError("ひらが.2ひらが"));
	}
	
	@Test
	public void testIllegalToken31() {
		assertFalse(checkSyntaxError(" (true && A((E(E(p1.dsa U p1.dd) U A X p1.as) && E(!p3.ds U p1.2ew)) U !(A X p2..gd && true)))"));
	}
	
	@Test
	public void testIllegalToken32() {
		assertFalse(checkSyntaxError( "E X W (java.awt.Something)"));
	}
	
	@Ignore("Refer to section 5.1.2 on the report.")
	@Test
	public void testIllegalToken33() {
		assertFalse(checkSyntaxError("java._2"));
	}
	
	@Test
	public void testIllegalToken34() {
		assertFalse(checkSyntaxError("E E E A A <-> java.java"));
	}
	
	@Test
	public void testIllegalToken35() {
		assertFalse(checkSyntaxError("E E"));
	}
	
	@Test
	public void testIllegalToken36() {
		assertFalse(checkSyntaxError("E A"));
	}
	
	@Test
	public void testIllegalToken37() {
		assertFalse(checkSyntaxError("A"));
	}
	
	@Test
	public void testIllegalToken38() {
		assertFalse(checkSyntaxError("E"));
	}
	
	@Test
	public void testIllegalToken39() {
		assertFalse(checkSyntaxError("M"));
	}
	
}
