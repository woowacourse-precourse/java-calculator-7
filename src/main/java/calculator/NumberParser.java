package calculator;

import java.util.List;

public class NumberParser {
    private static final String TRANSLATE_ERROR_MESSAGE = "잘못된 숫자 입니다.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "음수는 허용하지 않습니다.";

    public NumberParser() {
    }

    public List<Integer> parse(List<String> tokens) {
        return tokens.stream()
                .map(token -> {
                    int number = convertToInt(token);
                    if (number < 0) {
                        throw new IllegalArgumentException(NEGATIVE_VALUE_ERROR_MESSAGE);
                    }

                    return number;
                }).toList();
    }

    private int convertToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRANSLATE_ERROR_MESSAGE);
        }
    }
}
