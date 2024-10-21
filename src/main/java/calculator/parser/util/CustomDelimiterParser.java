package calculator.parser.util;

import calculator.exception.ErrorStatus;
import calculator.exception.ExceptionUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private final String regex;

    public CustomDelimiterParser(String prefix, String suffix) {
        prefix = prefix.replace("\\", "\\\\");
        suffix = suffix.replace("\\", "\\\\");
        this.regex = String.format("%s(.*?)%s", prefix, suffix);
    }

    public Character getDelimiter(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            validate(delimiter);
            return delimiter.charAt(0);
        }

        return null;
    }

    private void validate(String delimiters) {
        if (delimiters.isEmpty()) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.DELIMITER_INVALID_LENGTH);
        }
        if (delimiters.length() > 1) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.DELIMITER_INVALID_LENGTH);
        }
        if (hasDigits(delimiters)) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.DELIMITER_CONTAINS_NUMBER);
        }
    }

    private boolean hasDigits(String delimiters) {
        return delimiters.chars().anyMatch(Character::isDigit);
    }
}
