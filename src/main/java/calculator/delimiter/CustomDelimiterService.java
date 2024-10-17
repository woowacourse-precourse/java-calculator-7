package calculator.delimiter;

import java.util.Optional;

public class CustomDelimiterService {

    public final static String CUSTOM_DELIMITER_PREFIX = "//";
    public final static String CUSTOM_DELIMITER_SUFFIX = "\\n";
    public final String ESCAPE_CHARACTER = "\\";
    private final String INTEGER_REGEX = ".*\\d.*";

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

    private boolean hasCustomDelimiter(String input) {
        return input.contains(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private void validateFormat(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }

    private void validate(String customDelimiter) {
        validateEmptyDelimiter(customDelimiter);
        validateEscapeCharacter(customDelimiter);
        validateForDigits(customDelimiter);
    }

    private void validateEmptyDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
    }

    private void validateEscapeCharacter(String customDelimiter) {
        if (customDelimiter.contains(ESCAPE_CHARACTER)) {
            throw new IllegalArgumentException("이스케이프 문자가 포함되었습니다.");
        }
    }

    private void validateForDigits(String customDelimiter) {
        if (customDelimiter.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("커스텀 구분자엔 숫자가 포함될 수 없습니다.");
        }
    }
}
