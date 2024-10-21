package calculator.domain;

public class InputNumber {

    private static final String EXCEPTION_EMPTY_STRING = "빈 값을 입력하셨습니다.";
    private static final String EXCEPTION_CUSTOM_STRING = "올바른 형식으로 입력하세요.";
    private static final String CUSTOM_NUMBER_PART_DELIMITER = "\\";
    private static final String FIRST_CUSTOM_STRING = "//";

    private final String inputStrings;

    public InputNumber(String inputStrings) {
        validateEmptyString(inputStrings);
        validateLastIndex(inputStrings);
        validateCustomStrings(inputStrings);
        this.inputStrings = inputStrings;
    }

    public String getInputStrings() {
        return inputStrings;
    }

    private void validateEmptyString(String inputStrings) {
        if (inputStrings.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_EMPTY_STRING);
        }
    }

    private void validateCustomStrings(String inputStrings) {
        if (inputStrings.startsWith(FIRST_CUSTOM_STRING)) {
            validateCustomDelimiter(inputStrings);
        }
    }

    private void validateCustomDelimiter(String inputStrings) {
        if (!inputStrings.contains(CUSTOM_NUMBER_PART_DELIMITER)) {
            throw new IllegalArgumentException(EXCEPTION_CUSTOM_STRING);
        }
    }

    private void validateLastIndex(String inputStrings) {
        if (!Character.isDigit(inputStrings.charAt(inputStrings.length() - 1))) {
            throw new IllegalArgumentException(EXCEPTION_CUSTOM_STRING);
        }
    }
}
