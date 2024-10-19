package calculator.global.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public String extractDelimiter(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
