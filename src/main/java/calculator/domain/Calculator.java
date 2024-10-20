package calculator.domain;

import java.util.Arrays;

public class Calculator {

    private String expression;

    public Calculator(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    public int sum() {
        return Arrays.stream(getIntNumbers()).sum();
    }

    private int[] getIntNumbers() {
        String[] processedExpression = new DelimiterProcessor(expression).process();
        return new Numbers().parseToIntArray(processedExpression);
    }

}
