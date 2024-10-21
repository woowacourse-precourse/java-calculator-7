package calculator;

import java.util.List;

public class Calculator {
    public static int numberSum(List<String> numbers) {
        int sum = 0;
        for (String value : numbers) {
            validateNumber(value);
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private static void validateNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            validateNegative(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    private static void validateNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}