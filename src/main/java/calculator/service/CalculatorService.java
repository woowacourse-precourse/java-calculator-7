package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] tokens;

        if (input.startsWith("//")) {
            tokens = parse(input);
        } else {
            tokens = input.split(",|:");

        }
        return sum(tokens);
    }

    private String[] parse(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        } else {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number;
            try {
                number = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            sum += number;
        }
        return sum;
    }
}
