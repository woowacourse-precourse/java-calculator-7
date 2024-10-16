package calculator.domain;

import java.util.List;

public class StringParser {

    private static final int INITIAL_NUMBER = 0;
    private static final int SECOND_NUMBER = 2;
    private static final String STANDARD_DELIMITER = "[,|:]";
    private static final String FIRST_CUSTOM_STRING = "//";
    private static final String CUSTOM_NUMBER_PART_DELIMITER = "\\";
    private static final String EXCEPTION_EMPTY_STRING = "빈 값을 입력하셨습니다.";
    private static final String EXCEPTION_CUSTOM_STRING = "올바른 형식으로 입력하세요.";

    private final List<String> numbers;

    public StringParser(String inputStrings) {
        this.numbers = parseStrings(inputStrings);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    private List<String> parseStrings(String inputStrings) {
        validateEmptyString(inputStrings);
        if (!paresFirstString(inputStrings).equals(FIRST_CUSTOM_STRING)) {
            return parseStandardStrings(inputStrings);
        }
        validateCustomStrings(inputStrings);
        return parseCustomStrings(inputStrings);
    }

    private List<String> parseStandardStrings(String inputStrings) {
        String[] standardStrings = inputStrings.split(STANDARD_DELIMITER);
        return List.of(standardStrings);
    }

    private List<String> parseCustomStrings(String inputStrings) {
        String numberParts = inputStrings.substring(inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER) + SECOND_NUMBER);
        String[] customStrings = numberParts.split(extractCustomDelimiter(inputStrings));
        return List.of(customStrings);
    }

    private String extractCustomDelimiter(String inputStrings) {
        return inputStrings.substring(SECOND_NUMBER, inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER));
    }

    private String paresFirstString(String inputStrings) {
        return inputStrings.substring(INITIAL_NUMBER, SECOND_NUMBER);
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
