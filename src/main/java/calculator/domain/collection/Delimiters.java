package calculator.domain.collection;

import calculator.domain.value.Delimiter;
import calculator.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    // 기본 구분자
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    // 커스텀 구분자 관련
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE_CHAR = "\\n";
    private static final int DELIMITER_DEFINITION_OFFSET = 2;

    // 정규식 관련
    private static final String REGEX_DELIMITER = "|";

    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = List.copyOf(delimiters);
    }

    public static Delimiters of(String input) {
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(DEFAULT_DELIMITER_COMMA));
        delimiters.add(new Delimiter(DEFAULT_DELIMITER_COLON));

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int newlineIndex = input.indexOf(NEWLINE_CHAR);
            if (newlineIndex == -1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            String customDelimiterValue = input.substring(
                    CUSTOM_DELIMITER_PREFIX.length(), newlineIndex);
            if (customDelimiterValue.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            Delimiter customDelimiter = new Delimiter(customDelimiterValue);
            delimiters.add(customDelimiter);
        }

        return new Delimiters(delimiters);
    }

    public String removeDelimiterDefinition(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int newlineIndex = input.indexOf(NEWLINE_CHAR);
            return input.substring(newlineIndex + DELIMITER_DEFINITION_OFFSET);
        }
        return input;
    }

    public String[] split(String input) {
        String regex = delimiters.stream()
                .map(Delimiter::toRegex)
                .collect(Collectors.joining(REGEX_DELIMITER));
        return input.split(regex);
    }
}
