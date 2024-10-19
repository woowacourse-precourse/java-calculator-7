package calculator.delimiter;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static calculator.delimiter.BasicDelimiter.getBasicDelimiters;

public class CustomDelimiter {

    public static final String START_PREFIX = "//";
    public static final String REGEX_EXPRESSION = "//(.)\\\\n(.+)";

    public static Pattern getCustomDelimiterPattern() {
        return Pattern.compile(REGEX_EXPRESSION);
    }

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith(START_PREFIX);
    }

    public static Set<String> getCustomDelimiters(String customDelimiter) {
        Set<String> delimiters = new HashSet<>(getBasicDelimiters());
        delimiters.add(customDelimiter);
        return delimiters;
    }
}
