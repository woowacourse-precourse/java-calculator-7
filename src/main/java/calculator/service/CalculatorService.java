package calculator.service;

import calculator.entity.CalculationResult;
import calculator.enums.Delimiter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sumOfNumbers(tokens);
    }

    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(Delimiter.CUSTOM_PATTERN.getPattern()).matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        return input.split(Delimiter.DEFAULT.getPattern());  // 기본 구분자를 사용
    }

    private int sumOfNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(String::trim)
                .mapToInt(this::validateAndParse)
                .sum();
    }

    private int validateAndParse(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 음수는 허용되지 않습니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값: " + token);
        }
    }
}
