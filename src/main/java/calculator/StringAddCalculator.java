package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] tokens = tokenize(input);
        return sum(tokens);
    }

    private static String[] tokenize(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1));
            String numbers = m.group(2);
            return numbers.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private static int sum(String[] tokens) {
        // 임시로 0 반환
        return 0;
    }

}
