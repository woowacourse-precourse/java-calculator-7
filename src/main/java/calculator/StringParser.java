package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = "[,:]";
    public String[] parseString(String string) {
        if (string.isEmpty()) {
            return new String[]{"0"};
        }
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(string);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String input = matcher.group(2);
            if (input.isEmpty()) {
                return new String[]{"0"};
            }
            return input.split(delimiter);
        }
        return string.split(DEFAULT_DELIMITER);
    }
}
