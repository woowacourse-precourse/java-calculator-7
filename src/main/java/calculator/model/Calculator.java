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

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
