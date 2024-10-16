package calculator.model;

import java.util.Arrays;

public class Calculator {
    private final Expression expression;
    private final String operation;

    public Calculator(Expression expression, String operation) {
        this.expression = expression;
        this.operation = operation;
    }

    private String extractSeparator(Expression expression) {
        return expression.extractSeparator();
    }

    private String actualExpression(Expression expression) {
        return expression.extractActualExpression();
    }

    public Integer calculate() {
        String expressionValue = actualExpression(expression);

        switch (operation) {
            case "add":
                return addCalculate(expressionValue);
            case "multiply":
                return multiplyCalculate(expressionValue);
            case "subtract":
                return subtractCalculate(expressionValue);
            default:
                throw new IllegalArgumentException("잘못된 operation입니다.");
        }
    }

    private Integer addCalculate(final String expressionValue) {

        return Arrays.stream(expressionValue.split(extractSeparator(expression)))
            .map(part -> part.isEmpty() ? "0" : part)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private Integer multiplyCalculate(final String expressionValue) {

        return Arrays.stream(expressionValue.split(extractSeparator(expression)))
            .map(part -> part.isEmpty() ? "1" : part)
            .mapToInt(Integer::parseInt)
            .reduce(1, (a, b) -> a * b);
    }

    private Integer subtractCalculate(final String expressionValue) {

        return Arrays.stream(expressionValue.split(extractSeparator(expression)))
            .map(part -> part.isEmpty() ? "0" : part)
            .mapToInt(Integer::parseInt)
            .reduce((a, b) -> a - b)
            .orElseThrow(() -> new IllegalArgumentException("표현식이 비어 있습니다."));
    }

}
