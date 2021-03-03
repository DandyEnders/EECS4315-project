package ctl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.TestingTemplate;

public class TestAtomicProposition extends TestingTemplate {
	
	@Test
	public void testKoreanName() {
		assertTrue(checkSyntaxError("자.바.클.래.스"));
	}
	
	@Test
	public void testVietnamiseName() {
		assertTrue(checkSyntaxError("cụcCứt.cụcCứt"));
	}
	
	@Test
	public void testNumberFirst() {
		assertFalse(checkSyntaxError("1java.awt"));
	}
	
	@Test
	public void testSpecialCharacterFirst() {
		assertFalse(checkSyntaxError("#java.awt"));
	}
	
	@Test
	public void testVeryLongPackageNames() {
		assertTrue(checkSyntaxError("java.a.b.c.d.e.f.g.h.i.j.k.l.m.n.o.p.q.r.s.t.u.v.w.x.y.z"));
	}
	
	@Test
	public void testSingleName() {
		assertFalse(checkSyntaxError("Hello"));
	}
	
	@Test
	public void testJDKName1() {
		assertTrue(checkSyntaxError("java.lang.Object"));
	}
	
	@Test
	public void testJDKName2() {
		assertTrue(checkSyntaxError("java.util.AbstractCollection"));
	}
	
	@Test
	public void testJDKName3() {
		assertTrue(checkSyntaxError("java.util.AbstractList"));
	}
	
	@Test
	public void testJDKName4() {
		assertTrue(checkSyntaxError("java.util.ArrayList"));
	}
	
	@Test
	public void testJDKName5() {
		assertTrue(checkSyntaxError("java.util.AbstractQueue"));
	}
	
	@Test
	public void testJDKName6() {
		assertTrue(checkSyntaxError("java.util.concurrent.PriorityBlockingQueue"));
	}
	
	@Test
	public void testJDKName7() {
		assertTrue(checkSyntaxError("java.util.concurrent.LinkedBlockingDeque"));
	}
	
	@Test
	public void testJDKName8() {
		assertTrue(checkSyntaxError("java.security.spec.ECPoint"));
	}
	
	

}
