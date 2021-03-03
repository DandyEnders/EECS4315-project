package ctl;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class DescriptiveErrorListener extends BaseErrorListener {

    public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {

        throw new ParseCancellationException("haha:line " + line + ":" + charPositionInLine + " " + msg);
    }

}