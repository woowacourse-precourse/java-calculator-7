package calculator.parser.util;

import static calculator.exception.IllegalArgumentExceptionEnum.DIGIT_NOT_ALLOWED;
import static calculator.exception.IllegalArgumentExceptionEnum.INVALID_LENGTH;
import static calculator.exception.IllegalArgumentExceptionEnum.MULTIPLE_DELIMITERS;

import calculator.exception.ExceptionUtils;
import calculator.regex.RegexPatternMatcher;

public class CustomDelimiterParser {
    private final RegexPatternMatcher delimiterMatcher;

    public CustomDelimiterParser(String prefix, String suffix) {
        prefix = prefix.replace("\\", "\\\\");
        suffix = suffix.replace("\\", "\\\\");
        String regex = String.format("%s(.*?)%s", prefix, suffix);
        this.delimiterMatcher = new RegexPatternMatcher(regex);
    }

    public Character getDelimiter(String input) {
        int matchCount = delimiterMatcher.countMatches(input);
        if (matchCount == 0) {
            return null;
        }

        if (1 < matchCount) {
            ExceptionUtils.throwIllegalArgException(MULTIPLE_DELIMITERS);
        }

        String match = delimiterMatcher.getMatch(input);
        if (1 < match.length()) {
            ExceptionUtils.throwIllegalArgException(INVALID_LENGTH);
        } else if (match.isEmpty()) {
            ExceptionUtils.throwIllegalArgException(INVALID_LENGTH);
        } else if (Character.isDigit(match.charAt(0))) {
            ExceptionUtils.throwIllegalArgException(DIGIT_NOT_ALLOWED);
        }

        return match.charAt(0);
    }

}
