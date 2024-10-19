package calculator.util;

import static delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import delimiter.Delimiter;
import delimiter.Delimiters;
import java.util.regex.Matcher;

public class DelimiterExtractor {

    public void extractDelimitersFrom(final String input, final Delimiters delimiters) {
        Matcher matcher = CUSTOM_DELIMITER.getPattern().matcher(input);
        while (matcher.find()) {
            delimiters.addDelimiter(new Delimiter(matcher.group(1)));
        }
    }

}
