package calculator.model;

import calculator.model.delimiter.Delimiter;
import calculator.model.delimiter.Delimiters;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    private static final String EMPTY = "";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String INVALID_CHARACTER_MESSAGE = "입력 문자열에 유효하지 않은 문자가 포함되어 있습니다: ";

    private final String input;

    public InputManager(String input, Delimiters delimiters) {
        this.input = removeDelimiters(input, delimiters);
    }

    private String removeDelimiters(String input, Delimiters delimiters) {
        input = removeCustomDelimiterHeader(input, delimiters);
        return removeStandardDelimiters(input, delimiters);
    }

    private String removeCustomDelimiterHeader(String input, Delimiters delimiters) {
        for (Delimiter delimiter : delimiters.getDelimiters()) {
            if (delimiter.isCustomDelimiter()) {
                String delimiterHeader = createDelimiterHeader(delimiter);
                input = input.replace(delimiterHeader, EMPTY);
            }
        }
        return input;
    }

    private String createDelimiterHeader(Delimiter delimiter) {
        return CUSTOM_DELIMITER_PREFIX + delimiter.getDelimiter() + CUSTOM_DELIMITER_SUFFIX;
    }

    private String removeStandardDelimiters(String input, Delimiters delimiters) {
        for (Delimiter delimiter : delimiters.getDelimiters()) {
            input = input.replace(delimiter.getDelimiter(), EMPTY);
        }
        return input;
    }

    public List<Integer> stringToIntegers() {
        return Arrays.stream(input.split(EMPTY))
                .map(this::parseInteger)
                .collect(Collectors.toList());
    }

    private Integer parseInteger(String character) {
        try {
            return Integer.parseInt(character);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_CHARACTER_MESSAGE + character);
        }
    }
}
