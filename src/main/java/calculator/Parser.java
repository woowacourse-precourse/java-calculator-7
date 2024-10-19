package calculator;

import java.util.Arrays;

public class Parser {
    private static final String ERROR_MESSAGE = "잘못된 숫자 입니다.";

    public Parser() {

    }

    public int[] parseToNumber(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        return Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ERROR_MESSAGE);
                    }
                })
                .toArray();

    }

}
