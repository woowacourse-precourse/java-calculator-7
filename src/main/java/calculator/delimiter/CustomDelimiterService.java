package calculator.delimiter;

import java.util.Optional;

import static calculator.common.exception.Messages.*;

public class CustomDelimiterService {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final String ESCAPE = "\\";
    private final String NUMBER_REGEX = ".*\\d.*";

    public Optional<Delimiter> extract(String value) {
        if (!hasCustomDelimiter(value)) {
            return Optional.empty();
        }
        validateFormat(value);
        int delimiterIndex = value.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String extracted = value.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
        validate(extracted);
        return Optional.of(new Delimiter(extracted));
    }

    public String trimCustomDelimiter(String value) {
        if (!hasCustomDelimiter(value)) {
            return value;
        }
        int suffixIndex = value.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return value.substring(suffixIndex + CUSTOM_DELIMITER_SUFFIX.length());
    }

    private boolean hasCustomDelimiter(String value) {
        return value.contains(CUSTOM_DELIMITER_PREFIX) && value.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private void validateFormat(String value) {
        if (!value.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_FORMAT_WRONG);
        }
    }

    private void validate(String customDelimiter) {
        validateEmptyDelimiter(customDelimiter);
        validateEscapeCharacter(customDelimiter);
        validateForDigits(customDelimiter);
    }

    private void validateEmptyDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_EMPTY);
        }
    }

    private void validateEscapeCharacter(String customDelimiter) {
        if (customDelimiter.contains(ESCAPE)) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_CONTAINS_ESCAPE);
        }
    }

    private void validateForDigits(String customDelimiter) {
        if (customDelimiter.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_CONTAINS_NUMBER);
        }
    }
}
