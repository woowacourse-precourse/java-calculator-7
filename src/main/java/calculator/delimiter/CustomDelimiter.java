package calculator.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    public static Matcher getCustomDelimiterMatcher(String str) {
        return Pattern.compile("//(.)\\\\n(.*)").matcher(str);
    }

    public static String getCustomDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    public static String getNumbersWithCustomDelimiter(Matcher matcher) {
        return matcher.group(2);
    }
}
