package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        String[] numbers = splitInput(input);
        return sumNumbers(numbers);
    }

    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN, Pattern.DOTALL).matcher(input);

        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersPart = matcher.group(2);
            return numbersPart.split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int parsedNumber = parseNumber(number.trim());
            validateNumber(parsedNumber);
            sum += parsedNumber;
        }

        return sum;
    }

    private int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + number);
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}