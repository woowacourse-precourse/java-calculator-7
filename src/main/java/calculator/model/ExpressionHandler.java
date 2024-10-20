package calculator.model;

import java.util.StringTokenizer;

public class ExpressionHandler {

    private static final int DEFAULT_DELIMITER_COUNT = 2;
    private static final int CUSTOM_DELIMITER_RANGE = 4;

    private String expression;
    private final String delimiters;

    public ExpressionHandler(String expression, String delimiters) {
        this.expression = expression;
        this.delimiters = delimiters;
        if (hasCustomDelimiter(delimiters)) {
            filterExpression();
        }
    }

    private boolean hasCustomDelimiter(String delimiters) {
        return delimiters.length() > DEFAULT_DELIMITER_COUNT;
    }

    private void filterExpression() {
        expression = expression.substring(CUSTOM_DELIMITER_RANGE + 1);
    }

    public StringTokenizer getTokenizedExpression() {
        return new StringTokenizer(expression, delimiters, true);
    }

    public String getExpression() {
        return expression;
    }
}
