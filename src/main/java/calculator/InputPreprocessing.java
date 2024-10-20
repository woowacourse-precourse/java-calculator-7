package calculator;

import static calculator.Delimiter.*;

import java.util.Arrays;
import java.util.List;

public class InputPreprocessing {
    private static final long EMPTY_VALUE = 0L;
    private final Delimiter delimiter;

    public InputPreprocessing(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public List<Long> of(String input) {
        input = preprocessInput(input);
        return Arrays.stream(input.split(delimiter.get()))
                .map(this::processElement)
                .toList();
    }

    private String preprocessInput(String input) {
        if (delimiter.isCustomDelimiter()) {
            return input.substring(CUSTOM_DELIMITER_PREFIX_SIZE + CUSTOM_DELIMITER_SUFFIX_SIZE + delimiter.size());
        }
        return input;
    }

    private long processElement(String element) {
        validateSplit(element);
        return castingElementToLong(element);
    }

    private void validateSplit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("구분자 외의 문자나 음수가 존재합니다.");
        }
    }

    private long castingElementToLong(String element) {
        try {
            if (!element.isEmpty()) {
                long number = Long.parseLong(element);
                validatePositive(number);
                return number;
            }
            return EMPTY_VALUE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("더하는 값 중 너무 큰 수가 존재합니다.");
        }
    }

    private void validatePositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더하는 값은 양수만 가능합니다.");
        }
    }
}
