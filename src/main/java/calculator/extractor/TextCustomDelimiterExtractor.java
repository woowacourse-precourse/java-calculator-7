package calculator.extractor;

import java.util.regex.Matcher;

import static calculator.delimiter.CustomDelimiter.getCustomDelimiterPattern;
import static calculator.message.ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT;

public class TextCustomDelimiterExtractor {

    public String extractCustomDelimiter(String input) {
        return getCustomDelimiterMatcher(input).group(1);
    }

    public String extractText(String input) {
        return getCustomDelimiterMatcher(input).group(2);
    }

    private Matcher getCustomDelimiterMatcher(String input) {
        Matcher matcher = getCustomDelimiterPattern().matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        return matcher;
    }
}
