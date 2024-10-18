package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {
    public static final long SUM_INITIAL_VALUE = 0L;
    public static final int DELIMITER_START_INDEX = 2;
    private final List<Long> sequence;

    public InputSequence(String input) {
        String delimiter = validateCustomDelimiter(input);
        this.sequence = Arrays.stream(input.split(delimiter))
                            .map(part -> {
                                validateSplit(part);
                                return castingElementToLong(part);
                            })
                            .toList();
    }

    private String validateCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            for (int i = DELIMITER_START_INDEX; i < input.length(); i++) {
                if (input.startsWith("\\n", i)) {
                    return input.substring(DELIMITER_START_INDEX, i);
                }
            }
        }
        return "[,:]";
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
            throw new IllegalArgumentException("더 하는 값 중 너무 큰 수가 존재합니다.");
        }
    }

    private void validatePositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더 하는 값은 양수만 가능합니다.");
        }
    }

    public Long sum() {
        return sequence.stream().reduce(SUM_INITIAL_VALUE, Long::sum);
    }
}
