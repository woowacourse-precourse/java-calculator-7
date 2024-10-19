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
        if (hasCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiter(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String[] splitByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(Delimiter.CUSTOM_PATTERN.getPattern()).matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 커스텀 구분자 형식입니다.");
    }

    private String[] splitByDefaultDelimiter(String input) {
        return input.split(Delimiter.DEFAULT.getPattern());
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
