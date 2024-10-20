package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\\\";

    public static String extractDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find() == true) {
            return Pattern.quote(matcher.group(1));
        }
        return "[,:]";
    }
}
