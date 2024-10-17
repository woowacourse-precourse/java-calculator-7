package calculator.validator;

import calculator.enums.ErrorMessage;

public class CalculatorValidator {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final int CUSTOM_DELIMITER_SUFFIX_INDEX = 3;

    public boolean validateCustomDelimiterInput(String inputString) {
        if (!startsWithCustomDelimiterPrefix(inputString)) {
            return false;
        }
        if (!isValidFormat(inputString)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_FORMAT_ERROR.getMessage());
        }
        return true;
    }

    private boolean startsWithCustomDelimiterPrefix(String inputString) {
        return inputString.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private boolean isValidFormat(String inputString) {
        return inputString.indexOf(CUSTOM_DELIMITER_SUFFIX) == CUSTOM_DELIMITER_SUFFIX_INDEX;
    }
}

