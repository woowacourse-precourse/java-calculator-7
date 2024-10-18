package calculator.constant;

import java.util.regex.Pattern;

public class CustomDelimiter {

    public static final String START_PREFIX = "//";
    public static final String REGEX_EXPRESSION = "//(.)\\\\n(.+)";

    public static Pattern getCustomDelimiterPattern() {
        return Pattern.compile(REGEX_EXPRESSION);
    }
}
