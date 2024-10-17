package calculator.domain;

import java.util.List;
import java.util.Objects;

public class StringParser {

    private static final int SECOND_NUMBER = 2;
    private static final String STANDARD_DELIMITER = "[,|:]";
    private static final String FIRST_CUSTOM_STRING = "//";
    private static final String CUSTOM_NUMBER_PART_DELIMITER = "\\";
    private static final String EXCEPTION_EMPTY_STRING = "빈 값을 입력하셨습니다.";
    private static final String EXCEPTION_CUSTOM_STRING = "올바른 형식으로 입력하세요.";

    private final String inputStrings;

    public StringParser(String inputStrings) {
        validateEmptyString(inputStrings);
        this.inputStrings = inputStrings;
    }

    public String extractDelimiter() {
        if (!inputStrings.startsWith(FIRST_CUSTOM_STRING)) {
            return STANDARD_DELIMITER;
        }
        validateCustomStrings(inputStrings);
        return inputStrings.substring(SECOND_NUMBER, inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER));
    }

    public List<String> parseStrings(String delimiter) {
        if (Objects.equals(delimiter, STANDARD_DELIMITER)) {
            return parseStandardStrings(delimiter);
        }
        return parseCustomStrings(delimiter);
    }

    private List<String> parseStandardStrings(String delimiter) {
        String[] standardStrings = inputStrings.split(delimiter);
        return List.of(standardStrings);
    }

    private List<String> parseCustomStrings(String delimiter) {
        String numberParts = inputStrings.substring(inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER) + SECOND_NUMBER);
        String[] customStrings = numberParts.split(delimiter);
        return List.of(customStrings);
    }

    private void validateEmptyString(String inputStrings) {
        if (inputStrings.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_EMPTY_STRING);
        }
    }

    private void validateCustomStrings(String inputStrings) {
        if (!inputStrings.contains(CUSTOM_NUMBER_PART_DELIMITER)) {
            throw new IllegalArgumentException(EXCEPTION_CUSTOM_STRING);
        }
    }
}
