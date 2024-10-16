package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterProcessor {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_AND_NUMBER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_NUMBER_PATTERN = "[0-9]+([,|:][0-9]+)*";

    public String[] extractNumberStrings(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_AND_NUMBER_PATTERN).matcher(input);
        if (!matcher.matches()) {
            validateNumberPattern(input, DEFAULT_NUMBER_PATTERN);
            return splitNumberString(input, DEFAULT_DELIMITER_REGEX);
        }
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String numberPattern = buildNumberPattern(customDelimiter);
        validateNumberPattern(numberString, numberPattern);
        String delimiterRegex = buildDelimiterRegex(customDelimiter);
        return splitNumberString(numberString, delimiterRegex);
    }

    private void validateNumberPattern(String input, String numberPattern) {
        if (!input.matches(numberPattern)) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }

    private String buildNumberPattern(String customDelimiter) {
        return "[0-9]+([,|:|" + Pattern.quote(customDelimiter) + "][0-9]+)*";
    }

    private String buildDelimiterRegex(String customDelimiter) {
        return DEFAULT_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
    }

    private String[] splitNumberString(String input, String delimiterRegex) {
        return input.split(delimiterRegex);
    }
}
