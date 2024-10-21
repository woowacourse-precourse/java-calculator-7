package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String REGEX_CUSTOM = "//(.*?)[\\\\n]";
    private static final Pattern PATTERN_CUSTOM = Pattern.compile(REGEX_CUSTOM);

    private static final String DEFAULT_DELIMITER = ":|,";

    public String extractDelimiter(String inputString) {
        Matcher matcher = PATTERN_CUSTOM.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_DELIMITER;
    }
}
