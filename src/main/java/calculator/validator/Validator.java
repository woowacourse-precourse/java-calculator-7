package calculator.validator;

import static calculator.converter.Extractor.extractDelimiter;
import static calculator.converter.Extractor.extractNumberPart;
import static calculator.utils.ErrorConstants.*;

public class Validator {
    private static final String INVALID_CUSTOM_DELIMITER_PATTERN = "//[a-zA-Z0-9\\s-]+\\\\n.*";

    private final String defaultDelimiter;
    private final String prefix;
    private final String suffix;

    public Validator(String defaultDelimiter, String prefix, String suffix) {
        this.defaultDelimiter = defaultDelimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public void validateDelimiter(String value) {
        if (value.trim().isEmpty()) return;
        validateCustomDelimiterFormat(value);
        String delimiter = extractDelimiter(value, defaultDelimiter, prefix, suffix);
        String numberPart = extractNumberPart(value, prefix, suffix);
        validateDuplicateDelimiter(delimiter);
        validateNumberPart(numberPart, delimiter);
    }

    private void validateCustomDelimiterFormat(String value) {
        if (Character.isDigit(value.charAt(0))) {
            return;
        }
        if (!value.startsWith(prefix) || !value.contains(suffix)) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
        if (value.matches(INVALID_CUSTOM_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER);
        }
    }

    private void validateDuplicateDelimiter(String delimiter) {
        long distinctCount = delimiter.chars().distinct().count();
        if (distinctCount < delimiter.length()) {
            throw new IllegalArgumentException(ERROR_DELIMITER_DUPLICATE);
        }
    }

    private void validateNumberPart(String numberPart, String delimiter) {
        for (Character character : numberPart.toCharArray()) {
            validateNumberEmpty(character);
            validateNumberFormat(character, delimiter);
        }
    }

    private static void validateNumberEmpty(Character character) {
        if (Character.isWhitespace(character)) {
            throw new IllegalArgumentException(ERROR_NUMBER_EMPTY);
        }
    }

    private static void validateNumberFormat(Character character, String delimiter) {
        String charAsString = String.valueOf(character);
        if (Character.isDigit(character)) {
            return;
        }
        if (Character.isLetter(character)) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
        }
        if (!charAsString.matches(delimiter)) {
            throw new IllegalArgumentException(ERROR_DELIMITER_NOT_EXIST);
        }
    }
}