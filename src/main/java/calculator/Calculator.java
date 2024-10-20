package calculator;

import java.util.List;

public class Calculator {
    public static int numberSum(List<String> userInput) {
        return userInput.stream()
                .peek(Calculator::validateNumber)
                .mapToInt(Integer::parseInt)
                .sum();
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