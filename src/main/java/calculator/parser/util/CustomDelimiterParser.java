package calculator.parser.util;

import calculator.exception.ExceptionUtils;
import calculator.exception.IllegalArgumentExceptionEnum;
import calculator.regex.RegexPatternMatcher;

public class CustomDelimiterParser {
    private final RegexPatternMatcher customDelimiterMatcher;

    public CustomDelimiterParser(String prefix, String suffix) {
        prefix = prefix.replace("\\", "\\\\");
        suffix = suffix.replace("\\", "\\\\");
        String regex = String.format("%s(.*?)%s", prefix, suffix);
        this.customDelimiterMatcher = new RegexPatternMatcher(regex);
    }

    public Character getDelimiter(String input) {
        int countMatches = customDelimiterMatcher.countMatches(input);
        if (countMatches == 0) {
            return null;
        }

        if (1 < countMatches) {
            ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.MULTIPLE_DELIMITERS);
        }

        String match = customDelimiterMatcher.getMatch(input);
        if (1 < match.length()) {
            ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.INVALID_LENGTH);
        } else if (match.isEmpty()) {
            ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.INVALID_LENGTH);
        } else if (Character.isDigit(match.charAt(0))) {
            ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.DIGIT_NOT_ALLOWED);
        }

        return match.charAt(0);
    }

}
