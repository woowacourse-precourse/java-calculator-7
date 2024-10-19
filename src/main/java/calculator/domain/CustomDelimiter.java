package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NUMBER_REGEX = "[0-9]+([,|:|%s][0-9]+)*";
    private static final String DELIMITER_REGEX = ",|:|%s";

    @Override
    public boolean supports(String input) {
        Matcher matcher = getMatcher(input);
        if (!matcher.matches()) {
            return false;
        }
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String numberPattern = NUMBER_REGEX.formatted(Pattern.quote(customDelimiter));
        return numberString.matches(numberPattern);
    }

    @Override
    public String[] split(String input) {
        validate(input);
        Matcher matcher = getMatcher(input);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String delimiterRegex = DELIMITER_REGEX.formatted(Pattern.quote(customDelimiter));
        return numberString.split(delimiterRegex);
    }

    private Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}
