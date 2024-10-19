package calculator.model;

import java.util.Arrays;

public class Separator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static String customSeparator;

    private boolean hasCustomSeparator(String input) {
        if (input.startsWith("//")) {
            customSeparator = input.substring(2, 3);
            return true;
        } else {
            return false;
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private int[] getArray(String input, String separator) {
        try {
            return Arrays.stream(input.split(separator))
                    .mapToInt(Integer::parseInt)
                    .peek(this::validatePositiveNumber)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

    }

    public int[] extractNumbers(String input) {
        int[] numbers;
        if (hasCustomSeparator(input)) {
            input = input.substring(5);
            numbers = getArray(input, customSeparator);
            return numbers;
        } else if (input.isEmpty() || input.isBlank()) {
            return new int[]{0};
        } else {
            numbers = getArray(input, DEFAULT_SEPARATOR);
            return numbers;
        }
    }
}
