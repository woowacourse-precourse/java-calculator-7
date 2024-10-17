package calculator.delimiter;

import java.util.Optional;

import static calculator.common.exception.Messages.*;

public class CustomDelimiterService {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final String ESCAPE = "\\";
    private final String NUMBER_REGEX = ".*\\d.*";

    public Optional<Delimiter> extract(String input) {
        if (!hasCustomDelimiter(input)) {
            return Optional.empty();
        }
        validateFormat(input);
        int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String extracted = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
        validate(extracted);
        return Optional.of(new Delimiter(extracted));
    }

    public String trimCustomDelimiter(String input) {
        if (!hasCustomDelimiter(input)) {
            return input;
        }
        int newLineIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return input.substring(newLineIndex + CUSTOM_DELIMITER_SUFFIX.length());
    }

    private boolean hasCustomDelimiter(String input) {
        return input.contains(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private void validateFormat(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
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
