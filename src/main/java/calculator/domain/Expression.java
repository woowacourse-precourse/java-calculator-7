package calculator.domain;

public class Expression {
    private final String expression;
    private final String delimiter;

    public Expression(String expression, String delimiter) {
        this.expression = expression;
        this.delimiter = delimiter;
    }

    public String getExpression() {
        return expression;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
