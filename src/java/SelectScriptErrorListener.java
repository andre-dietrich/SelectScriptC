package S2;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

import java.util.List;
import java.util.ArrayList;

import clojure.lang.IDeref;

public class SelectScriptErrorListener extends BaseErrorListener {
    public static SelectScriptErrorListener INSTANCE = new SelectScriptErrorListener();

    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private ArrayList<String> error_msg = new ArrayList<String>();

    public ArrayList<String> getErrors() {
        return error_msg;
    }

    public boolean hasErrors() {
        return error_msg.size() > 0;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine,
                        String msg, RecognitionException e)
    {
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%d:%d: ", line, charPositionInLine);
        }

        error_msg.add(sourceName+"line "+line+":"+charPositionInLine+" "+msg);
    }
}
