package calculator.model;

import calculator.utils.StringParser;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String input) {
        // 빈 문자열 또는 null인 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.parse(input);
        int sum = 0;
        List<String> errors = new ArrayList<>();

        // 음수 값 검사
        for (String number : numbers) {
            if (!number.matches("-?\\d+")) { // 숫자 유효성 검사
                errors.add("숫자가 아닌 값이 포함되어 있습니다: " + number);
            } else {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    errors.add("음수는 허용되지 않습니다: " + number);
                }
                sum += num;
            }
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }

        return sum;
    }
}
