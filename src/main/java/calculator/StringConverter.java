package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private final static String NOT_VALIDATE_NUMBER = "유효하지 않은 숫자 형식입니다.";
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다: ";

    public List<Integer> convertToNumbers(String[] inputs) {
        return Arrays.stream(inputs)
                .map(this::convertToInt)
                .collect(Collectors.toList());
    }

    private int convertToInt(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            validatePositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
