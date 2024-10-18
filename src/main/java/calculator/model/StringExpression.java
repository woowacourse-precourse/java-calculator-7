package calculator.model;

import static calculator.constant.ErrorMessage.INVALID_INPUT;

import calculator.util.DelimiterParser;

public class StringExpression {
    private final String expression;
    private final String customDelimiter;

    public StringExpression(String expression) {
        validateNullOrEmpty(expression);
        this.expression = expression.replace("\\n", "\n");
        this.customDelimiter = DelimiterParser.parseCustomDelimiter(this.expression);
    }

    private void validateNullOrEmpty(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
