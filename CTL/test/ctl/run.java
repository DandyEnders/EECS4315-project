package ctl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class run {
	public static void main( String[] args) throws Exception 
	{

		ANTLRInputStream input = new ANTLRInputStream( System.in);

		CTLLexer lexer = new CTLLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		CTLParser parser = new CTLParser( tokens);
		ParseTree tree = parser.root(); // begin parsing at rule 'r'
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
	}

}
