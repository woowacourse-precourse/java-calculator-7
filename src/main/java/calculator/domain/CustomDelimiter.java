package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NUMBER_REGEX_PREFIX = "[0-9]+([,|:|";
    private static final String NUMBER_REGEX_SUFFIX = "][0-9]+)*";
    private static final String DELIMITER_REGEX_PREFIX = ",|:|";

    @Override
    public boolean supports(String input) {
        Matcher matcher = getMatcher(input);
        if (!matcher.matches()) {
            return false;
        }
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String numberPattern = NUMBER_REGEX_PREFIX + Pattern.quote(customDelimiter) + NUMBER_REGEX_SUFFIX;
        return numberString.matches(numberPattern);
    }

    @Override
    public String[] split(String input) {
        Matcher matcher = getMatcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String delimiterRegex = DELIMITER_REGEX_PREFIX + Pattern.quote(customDelimiter);
        return numberString.split(delimiterRegex);
    }

    private Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}
