package calculator.domain;

public class Expression {
    private final String expression;
    private final String delimiter;
    private final boolean isCustomDelimiter;

    public Expression(String expression, String delimiter, boolean isCustomDelimiter) {
        this.expression = expression;
        this.delimiter = delimiter;
        this.isCustomDelimiter = isCustomDelimiter;
    }

    public String getExpression() {
        return expression;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean isCustomDelimiter() {
        return isCustomDelimiter;
    }
}
