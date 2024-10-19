package calculator.model;

import java.util.StringTokenizer;

public class ExpressionHandler {

    private static final int CUSTOM_DELIMITER_RANGE = 4;

    private String expression;
    private final String delimiters;
    private final boolean customDelimiterFlag;

    public ExpressionHandler(String expression, String delimiters, boolean customDelimiterFlag) {
        this.expression = expression;
        this.delimiters = delimiters;
        this.customDelimiterFlag = customDelimiterFlag;

        filterExpression();
    }

    private void filterExpression() {
        if (customDelimiterFlag) {
            expression = expression.substring(CUSTOM_DELIMITER_RANGE + 1);
        }
    }

    public StringTokenizer tokenizeExpression() {
        return new StringTokenizer(expression, delimiters, true);
    }

    public String getExpression() {
        return expression;
    }
}
