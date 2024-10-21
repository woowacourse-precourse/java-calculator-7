package calculator.domain;

import java.util.List;

public class Calculator {

    public Long calculateSum(List<Long> numbers) {
        validateNumberCondition(numbers);

        try {
            return numbers.stream()
                    .reduce(0L, Math::addExact);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("숫자의 합이 너무 큽니다.", e);
        }
    }

    private void validateNumberCondition(List<Long> numbers) {
        numbers.forEach(number -> {
            if (number <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다: " + number);
            }
        });
    }
}