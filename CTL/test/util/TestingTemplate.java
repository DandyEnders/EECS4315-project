package util;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import ctl.CTLLexer;
import ctl.CTLParser;

public class TestingTemplate {
	public final static String TRUE = "true";
	public final static String FALSE = "false";
	public final static String NEG = "!";
	public final static String AND = "&&";
	public final static String OR = "||";
	public final static String LB = "(";
	public final static String RB = ")";
	public final static String FA = "A";
	public final static String EX = "E";
	public final static String NEXT = "X";
	public final static String U = "U";
	public final static String EVENT = "F";
	public final static String ALWAYS = "G";
	public final static String IMP = "->";
	public final static String IFF = "<->";
	public final static String AP[] = { "p1", "p2", "p3" };

	public String remove(String f) {
		if (f.contains("formula ")) {
			f = f.replaceAll("formula ", "");

		}
		if (f.contains("(root ")) {
			f = f.substring(6, f.length() - 1);

		}
		return f;
	}
	
	public boolean checkSyntaxError(String s) {
		Lexer l1 = new CTLLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(l1);
		CTLParser parser = new CTLParser(tokens);
		
		l1.removeErrorListeners();
		l1.addErrorListener(DescriptiveErrorListener.INSTANCE);
		
		parser.removeErrorListeners();
		parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
		
		try {
			parser.root();

		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}
	
	public boolean checkSementicError(String groundTruth, String testSubject) {
		Lexer lexer = new CTLLexer(CharStreams.fromString(testSubject));
		CommonTokenStream token = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(token);
		ParseTree tree = parser.root();
		String formula = remove(tree.toStringTree(parser));
		return formula.equals(groundTruth);
	}
	
}
