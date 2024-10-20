package calculator.number.rule;

import java.util.Arrays;

public class PositiveNumbersRule implements NumbersRule {
    @Override
    public boolean isInvalid(int[] numbers) {
        return 0 < countNonPositiveNumber(numbers);
    }

    private long countNonPositiveNumber(int[] result) {
        return Arrays.stream(result).filter(this::isNonPositive).count();
    }

    private boolean isNonPositive(int number) {
        return number <= 0;
    }
}
