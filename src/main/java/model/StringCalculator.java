package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.matches()) {
            String customDelimiter = Pattern.quote(m.group(1));
            String numbers = m.group(2);
            return sumNumbers(numbers.split(customDelimiter));
        }
        return sumNumbers(input.split(DEFAULT_DELIMITER));
    }

    private static int sumNumbers(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += toPositiveInt(token);
        }
        return sum;
    }

    private static int toPositiveInt(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + token);
        }
    }
}
