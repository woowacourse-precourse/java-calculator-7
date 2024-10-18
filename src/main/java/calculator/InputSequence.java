package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {
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

    private long castingElementToLong (String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("더 하는 값 중 너무 큰 수가 존재합니다.");
        }
    }
}
