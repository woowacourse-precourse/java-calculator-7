package calculator;

import java.util.List;

public class Calculator {

    private final ExpressionParser expressionParser;

    public Calculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public int calculateSum(String expression) {
        List<Integer> numbers = expressionParser.parse(expression);
        validatePositive(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validatePositive(List<Integer> numbers) {
        boolean containsNonPositiveNumber = numbers.stream()
                .anyMatch(number -> number < 0);
        if (containsNonPositiveNumber) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
