package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = tokenize(input);
        return sumTokens(tokens);
    }

    private static String[] tokenize(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parsePositiveInteger(token);
            sum += number;
        }
        return sum;
    }

    private static int parsePositiveInteger(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
        return number;
    }
}
