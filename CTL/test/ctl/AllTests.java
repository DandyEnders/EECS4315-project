package ctl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAssociativity.class, TestAtomicProposition.class, TestConnectives.class, TestNotCTLFormula.class,
		TestPrecedence.class })
public class AllTests {

}
