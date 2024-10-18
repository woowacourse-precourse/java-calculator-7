package calculator.domain;

public class CalculateExpression {

    private final String expression;

    private CalculateExpression(String expression) {
        this.expression = expression;
    }

    public static CalculateExpression fromString(String expression) {
        return new CalculateExpression(expression);
    }
}
