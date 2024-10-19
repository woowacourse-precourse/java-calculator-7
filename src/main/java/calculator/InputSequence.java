package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {
    public static final long SUM_INITIAL_VALUE = 0L;
    private final List<Long> sequence;

    public InputSequence(String input) {
        Delimiter delimiter = new Delimiter(input);
        this.sequence = Arrays.stream(input.split(delimiter.get()))
                            .map(part -> {
                                validateSplit(part);
                                return castingElementToLong(part);
                            })
                            .toList();
    }

    private void validateSplit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("구분자 외의 문자가 존재합니다.");
        }
    }

    private long castingElementToLong(String input) {
        try {
            long number = Long.parseLong(input);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("더하는 값 중 너무 큰 수가 존재합니다.");
        }
    }

    private void validatePositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더하는 값은 양수만 가능합니다.");
        }
    }

    public Long sum() {
        return sequence.stream().reduce(SUM_INITIAL_VALUE, (a,b) -> {
            long sum = a + b;
            if (sum < 0) {
                throw new IllegalArgumentException("더한 값이 너무 큽니다.");
            }
            return sum;
        });
    }
}
