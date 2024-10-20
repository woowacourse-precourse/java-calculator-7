package calculator.domain;

import java.util.Arrays;

public class Calculator {

    private String expression;

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        this.expression = expression;
    }

    public int sum() {
        return Arrays.stream(getIntNumbers()).sum();
    }

    private int[] getIntNumbers() {
        String[] processedExpression = new DelimiterProcessor(expression).process();
        return new Numbers().parseToIntArray(processedExpression);
    }

}
