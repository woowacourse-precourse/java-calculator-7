package calculator;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String input) {
        // 빈 문자열 또는 null일 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            return CustomDelimiterCalculator.calculateSum(input); // 커스텀 구분자 처리
        }

        return calculateSum(input); // 기본 구분자 처리 및 예외 처리
    }

    // 기본 구분자 처리 및 잘못된 값(음수, 숫자 외 문자) 처리
    private static int calculateSum(String input) {
        String[] tokens = input.split("[,|:]");

        // 음수 및 숫자 외의 문자가 있는지 확인
        int sum = 0;
        for (String token : tokens) {
            int number;
            try {
                number = Integer.parseInt(token.trim()); // 숫자로 변환
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }

            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }

            sum += number;
        }
        return sum;
    }
}

