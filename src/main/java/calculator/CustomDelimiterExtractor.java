package calculator;

import java.util.Optional;

public class CustomDelimiterExtractor {
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public Optional<String> extractCustomDelimiterFrom(String input) {
        if (hasCustomDelimiter(input)) {
            return Optional.of(getCustomDelimiter(input));
        }
        return Optional.empty();
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String getCustomDelimiter(String input) {
        String delimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), input.indexOf(CUSTOM_DELIMITER_SUFFIX));
        if (isNotSingleCharacter(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 단일 문자만 올 수 있습니다.");
        }
        return delimiter;
    }

    private boolean isNotSingleCharacter(String delimiter) {
        return delimiter.length() != 1;
    }
}
