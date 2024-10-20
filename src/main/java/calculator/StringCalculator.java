package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = split(input);
        return sum(tokens);
    }

    private String[] split(String input) {
        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }

        return input.split(delimiter);
    }

    private int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            try {
                sum += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        return sum;
    }
}

