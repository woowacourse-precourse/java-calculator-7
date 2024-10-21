package calculator;

import java.util.List;

public class Calculator {
    public static int numberSum(List<String> numbers) {
        int sum = 0;
        for (String value : numbers) {
            validatePositiveNumber(value);
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private static void validatePositiveNumber(String num) {
        if (!num.matches("\\d+")) {
            throw new IllegalArgumentException("올바른 양수와 구분자를 입력해 주세요.");
        }
    }
}