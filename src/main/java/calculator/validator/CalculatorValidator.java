package calculator.validator;

import calculator.enums.ErrorMessage;

public class CalculatorValidator {

    private final int REQUIRE_CUSTOM_DELIMITER_LENGTH = 5;
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final int CUSTOM_DELIMITER_SUFFIX_INDEX = 3;

    public boolean validateCustomDelimiterInput(String inputString) {
        if (!isValidLength(inputString) || !startsWithCustomDelimiterPrefix(inputString)) {
            return false;
        }
        if (!isValidFormat(inputString)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_FORMAT_ERROR.getMessage());
        }
        return true;
    }

    private boolean isValidLength(String inputString) {
        return inputString.length() >= REQUIRE_CUSTOM_DELIMITER_LENGTH;
    }

    private boolean startsWithCustomDelimiterPrefix(String inputString) {
        return inputString.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private boolean isValidFormat(String inputString) {
        return inputString.indexOf(CUSTOM_DELIMITER_SUFFIX) == CUSTOM_DELIMITER_SUFFIX_INDEX;
    }
}

