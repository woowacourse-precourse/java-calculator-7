package calculator;

import java.util.Arrays;

public class NumberParser {
    private static final String TRANSLATE_ERROR_MESSAGE = "잘못된 숫자 입니다.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "음수는 허용하지 않습니다.";

    public NumberParser() {
    }

    public int[] parse(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::convertToInt)
                .mapToInt(number -> {
                    if (number < 0) {
                        throw new IllegalArgumentException(NEGATIVE_VALUE_ERROR_MESSAGE);
                    }
                    return number;
                }).toArray();
    }

    private int convertToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRANSLATE_ERROR_MESSAGE);
        }
    }
}
