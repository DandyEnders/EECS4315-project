package ctl;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

class TestCTL {
	
	@Test
	void test() {
		Lexer lexer = new CTLLexer(CharStreams.fromString("a && "));

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(tokens);
		ParseTree tree = parser.root();
		
		System.out.println(tree.toStringTree());
		
	}

}
