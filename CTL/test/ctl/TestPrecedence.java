package ctl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.TestingTemplate;

public class TestPrecedence extends TestingTemplate {
	
	
	@Test
	public void testPrecedance1() {
		assertTrue(checkSementicError("(( (((true) && (false)) || (true)) ))", LB + TRUE + AND + FALSE + OR + TRUE + RB));
	}
	
	@Test
	public void testPrecedance2() {
		assertTrue(checkSementicError("(A X (true))", FA + NEXT + TRUE));
	}
	
	@Test
	public void testPrecedance3() {
		assertTrue(checkSementicError("(A X (E X (true)))", FA + NEXT + EX + NEXT + TRUE));
	}
	
	@Test
	public void testPrecedance4() {
		assertTrue(checkSementicError("(A F (E F (! (false))))", FA + EVENT + EX + EVENT + NEG + FALSE));
	}
	
	@Test
	public void testPrecedance5() {
		assertTrue(checkSementicError("(A) (E) (true) (( (true) U) (false)", FA + EX + TRUE + LB + TRUE + U + FALSE + RB));
	}
	
	@Test
	public void testPrecedance6() {
		assertTrue(checkSementicError("(E ( (E X (true)) ))", EX + LB + EX + NEXT + TRUE + RB));
	}
	
	@Test
	public void testPrecedance7() {
		assertTrue(checkSementicError("(E X (A X (true)))", EX + NEXT + FA + NEXT + TRUE));
	}

}
