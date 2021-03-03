package ctl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.TestingTemplate;

public class TestAssociativity extends TestingTemplate {
	
	@Test
	public void testAssociativity1() {
		assertTrue(checkSementicError("((true) || ((true) || (true)))", TRUE + OR + TRUE + OR + TRUE));
	}
	
	@Test
	public void testAssociativity2() {
		assertTrue(checkSementicError("((true) -> ((true) -> (true)))", TRUE + IMP + TRUE + IMP + TRUE));
	}

	@Test
	public void testAssociativity3() {
		assertTrue(checkSementicError("(((true) && (true)) && (true))", TRUE + AND + TRUE + AND + TRUE));
	}

	@Test
	public void testAssociativity4() {
		assertTrue(checkSementicError("((true) <-> ((true) <-> (true)))", TRUE + IFF + TRUE + IFF + TRUE));
	}

	@Test
	public void testAssociativity5() {
		assertTrue(checkSementicError("(A U) (true)", FA + U + TRUE));
	}

	@Test
	public void testAssociativity6() {
		assertTrue(checkSementicError("(E U) (false)", EX + U + FALSE));
	}
	
}
