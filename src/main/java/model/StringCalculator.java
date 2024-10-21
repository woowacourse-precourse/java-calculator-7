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
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
