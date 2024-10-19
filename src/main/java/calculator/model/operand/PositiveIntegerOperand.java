package calculator.model.operand;

import java.util.List;

public class PositiveIntegerOperand extends IntegerOperand {

    public PositiveIntegerOperand(final List<Integer> numbers) {
        super(numbers);
        validatePositive(numbers);
    }

    private void validatePositive(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 0)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("피연산자로 음수는 허용되지 않습니다: " + number);
                });
    }
}
