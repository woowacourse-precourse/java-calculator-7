package calculator;

import java.util.Arrays;

public class Parser {
    private static final String TRANSLATE_ERROR_MESSAGE = "잘못된 숫자 입니다.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "음수는 허용하지 않습니다.";

    public Parser() {

    }

    public int[] parseToNumber(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        int result = Integer.parseInt(number);

                        if (result < 0) {
                            throw new IllegalArgumentException(NEGATIVE_VALUE_ERROR_MESSAGE);
                        }
                        return Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(TRANSLATE_ERROR_MESSAGE);
                    }
                })
                .toArray();

    }

}
