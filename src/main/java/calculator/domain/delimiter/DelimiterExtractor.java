package calculator.domain.delimiter;

import static calculator.domain.delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import java.util.regex.Matcher;

public class DelimiterExtractor {

    public Delimiters extractDelimitersFrom(final String input, final Delimiters delimiters) {
        Matcher matcher = CUSTOM_DELIMITER.getPattern().matcher(input);
        Delimiters totalDelimiters = delimiters;
        while (matcher.find()) {
            totalDelimiters = totalDelimiters.addDelimiter(new Delimiter(matcher.group(1)));
        }

        return totalDelimiters;
    }

}
