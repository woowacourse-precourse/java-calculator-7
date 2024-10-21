package calculator;

import java.util.List;

public class Calculator {
    private static final String POSITIVE_NUMBER_REGEX = "\\d+";
    private static final String INVALID_INPUT_MESSAGE = "올바른 양수와 구분자를 입력해 주세요.";

    public static int numberSum(List<String> numbers) {
        int sum = 0;
        for (String value : numbers) {
            validatePositiveNumber(value);
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private static void validatePositiveNumber(String num) {
        if (!num.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}