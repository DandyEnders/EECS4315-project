package ctl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.TestingTemplate;

public class TestConnectives extends TestingTemplate {
	
	@Test
	public void testConnectives1() {
		assertTrue(checkSementicError("((true) && (false))", TRUE + AND + FALSE));
	}
	
	@Test
	public void testConnectives2() {
		assertTrue(checkSementicError("((true) || (false))", TRUE + OR + FALSE));
	}
	
	@Test
	public void testConnectives3() {
		assertTrue(checkSementicError("(! (true))", NEG + TRUE));
	}
	
	@Test
	public void testConnectives4() {
		assertTrue(checkSementicError("((true) -> (true))", TRUE + IMP + TRUE));
	}
	
	@Test
	public void testConnectives5() {
		assertTrue(checkSementicError("((( ((true) && (true)) )) && (true))", LB + TRUE + AND + TRUE + RB + AND + TRUE));
	}
	
	@Test
	public void testConnectives6() {
		assertTrue(checkSementicError("((true) <-> (false))", TRUE + IFF + FALSE));
	}
	
	@Test
	public void testConnectives7() {
		assertTrue(checkSementicError("((E X (true)) || (false))", EX + NEXT + TRUE + OR + FALSE));
	}
	
	@Test
	public void testConnectives8() {
		assertTrue(checkSementicError("(A ( (true) U (false) ))", FA + LB + TRUE + U + FALSE + RB));
	}
	
	@Test
	public void testConnectives9() {
		assertTrue(checkSementicError("((E F (true)) && (true))", EX + EVENT + TRUE + AND + TRUE));
	}
	
	@Test
	public void testConnectives10() {
		assertTrue(checkSementicError("(A G (true))", FA + ALWAYS + TRUE));
	}

}
