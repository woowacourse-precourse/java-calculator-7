package calculator;

import java.util.Arrays;

public class Calculator {

    private static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다";
    private static final String INVALID_NUMBER_ERROR = "잘못된 숫자 형식입니다";


    public int[] parseInput(String input, String delimiter) {
        String[] tokens = input.split(delimiter + "|\n");
        return Arrays.stream(tokens)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    public int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR, e);
        }
    }

    public int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}