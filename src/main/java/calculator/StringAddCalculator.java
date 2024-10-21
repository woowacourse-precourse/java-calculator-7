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
        int total = 0;
        for (String token : tokens) {
            int number = toInt(token);
            total += number;
        }
        return total;
    }

	private static int toInt(String token) {
		try {
			int number = Integer.parseInt(token);
			if (number < 0) {
				throw new IllegalArgumentException("음수는 허용되지 않습니다.");
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
		}
	}

}
