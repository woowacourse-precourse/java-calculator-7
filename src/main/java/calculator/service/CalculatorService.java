package calculator.service;

import calculator.enums.Delimiter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public int calculate(String input) {
        if (isEmptyInput(input)) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sumOfNumbers(tokens);
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(Delimiter.CUSTOM_PATTERN.getPattern()).matcher(input);
        String delimiters = Delimiter.DEFAULT.getPattern(); // 기본 구분자(쉼표, 콜론)

        if (matcher.matches()) {
            delimiters = getCombinedDelimiters(matcher, delimiters);
            input = matcher.group(2); // 숫자 부분만 추출
        }

        return input.split(delimiters);
    }

    private String getCombinedDelimiters(Matcher matcher, String defaultDelimiters) {
        String customDelimiter = Pattern.quote(matcher.group(1));
        return defaultDelimiters + "|" + customDelimiter;
    }


    private int sumOfNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(String::trim)
                .mapToInt(this::validateAndParse)
                .sum();
    }

    private int validateAndParse(String token) {
        int number = parseToInt(token);
        validateNegativeNumber(number);
        return number;
    }

    private int parseToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값: " + token);
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 허용되지 않습니다: " + number);
        }
    }
}
