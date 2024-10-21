package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

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

        return input.split(",|:"); // 기본 구분자 처리
    }
}
