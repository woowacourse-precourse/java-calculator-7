package calculator.domain.delimiter;

import static calculator.domain.delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import java.util.regex.Matcher;

public class DelimiterExtractor {

    public void extractDelimitersFrom(final String input, final Delimiters delimiters) {
        Matcher matcher = CUSTOM_DELIMITER.getPattern().matcher(input);
        while (matcher.find()) {
            delimiters.addDelimiter(new Delimiter(matcher.group(1)));
        }
    }

}
