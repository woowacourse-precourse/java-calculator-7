package calculator;

import java.util.Arrays;

public class Calculator {
    public static int calculateSum(String[] numbers) {
        return Arrays.stream(numbers) // 배열을 스트림으로 변환하여, 원소들을 차례로 처리
                     .mapToInt(Calculator::parseNumber) // parseNumber 메서드를 사용하여 문자열을 숫자로 변환
                     .sum();
    }

    private static int parseNumber(String number) {
        try {
            // 공백 제거
            String trimmedNumber = number.trim();
            // 공백인 경우 0으로 처리
            if (trimmedNumber.isEmpty()) {
                return 0;
            }
            int parsedNumber = Integer.parseInt(trimmedNumber);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 애플리케이션은 종료됩니다. 입력값:" + number, e);
        }
    }
}