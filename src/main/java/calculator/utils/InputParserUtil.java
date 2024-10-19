package calculator.utils;

import calculator.validation.NumberValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParserUtil {
    private static final String BASIC_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)";

    public static String[] seperator(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split("\\" + customDelimiter, -1);
        }

        return input.split(BASIC_DELIMITERS);
    }

    public static int[] numberStrListToIntList(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            NumberValidator.isNotNumberOrNotPositive(numbers[i]);
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }
}
