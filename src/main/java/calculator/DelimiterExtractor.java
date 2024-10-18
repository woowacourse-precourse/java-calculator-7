package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\\\n");
    private String delimiter;

    public DelimiterExtractor() {
        delimiter = DEFAULT_DELIMITER;
    }

    public String extractDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            return input.substring(matcher.end());
        }
        return input;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
