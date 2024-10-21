package calculator.model;

import calculator.utils.StringParser;

public class Calculator {
    public int add(String input) {
        // 빈 문자열 또는 null인 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.parse(input);
        int sum = 0;

        // 음수 값 검사
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += num;
        }

        return sum;
    }
}
