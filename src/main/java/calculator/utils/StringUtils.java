package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String[] extractNumbers(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        Matcher matcher = Pattern.compile("^//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            delimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(matcher.group(1));
            input = matcher.group(2);
        }
        if (isEmpty(input)) {
            return new String[0];
        }
        return input.split(delimiters);
    }
}
