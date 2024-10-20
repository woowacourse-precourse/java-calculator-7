package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int calculate(String input) {
        if (isDefaultPattern(input)) {
            return sumWithDefaultSeparators(input);
        }
        if (isCustomPattern(input)) {
            return sumWithCustomSeparator(input);
        }
        throw new IllegalArgumentException();
    }

    private static boolean isDefaultPattern(String input) {
        return matchPattern(input, "^\\d*([,:]\\d+)*$");
    }

    private static boolean isCustomPattern(String input) {
        return matchPattern(input, "^//(.)\\\\n\\d*(\\1\\d+)*$");
    }

    private static boolean matchPattern(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static int sumWithDefaultSeparators(String input) {
        String[] numbers = input.split("[,:]");
        return sum(numbers);
    }

    private static int sumWithCustomSeparator(String input) {
        String separator = input.substring(2, 3);
        String[] numbers = input.substring(5).split(Pattern.quote(separator));
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += parseAndValidateNumber(number);
        }
        return total;
    }

    private static int parseAndValidateNumber(String number) {
        if (number.matches("\\d+")) {
            return Integer.parseInt(number);
        }
        return 0; // Return 0 for invalid numbers instead of ignoring
    }
}
