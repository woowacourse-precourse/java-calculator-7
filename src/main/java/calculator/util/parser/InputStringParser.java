package calculator.util.parser;

import static calculator.constant.Delimiter.COLON;
import static calculator.constant.Delimiter.COMMA;
import static calculator.constant.Delimiter.CUSTOM_DELIMITER_FORMAT;
import static calculator.constant.Delimiter.CUSTOM_DELIMITER_PATTERN;

import java.util.regex.Matcher;


public class InputStringParser implements StringParser {

    @Override
    public String extractCustomDelimiter(final String str) {
        String customDelimiter = "";
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (matcher.find()) {
            customDelimiter = matcher.group(1);
        }
        return customDelimiter;
    }

    @Override
    public String removeCustomDelimiterFormat(final String str) {
        return str.replaceFirst(CUSTOM_DELIMITER_FORMAT, "");
    }

    @Override
    public String[] extractTokens(final String str) {
        final String customDelimiter = extractCustomDelimiter(str);
        final String regex = "[" + COMMA + COLON + customDelimiter + "]";
        return removeCustomDelimiterFormat(str).split(regex);
    }
}
