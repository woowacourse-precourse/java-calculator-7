package calculator.domain;

import calculator.exception.input.CalculatorException;

import static calculator.exception.input.CalculatorExceptionMessage.WRONG_CUSTOM_DELIMITER_FORMAT;

public class Calculator {

    private static final String COMMA = ",";
    private static final String COLON = ";";
    private static final String CUSTOM_DELIMITER_PREFIX_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX_FORMAT = "\n";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    private static final String NUMBER_INCLUDE_REGEX = ".*[0-9].*";

    public String getCustomDelimiter(String stringWithDivisionMark) {
        if (stringWithDivisionMark.startsWith(CUSTOM_DELIMITER_PREFIX_FORMAT)) {
            return extractCustomDelimiter(stringWithDivisionMark);
        }
        validateNumber(stringWithDivisionMark);
        return null;
    }

    private String extractCustomDelimiter(String stringWithDivisionMark) {
        int endIndex = stringWithDivisionMark.indexOf(CUSTOM_DELIMITER_SUFFIX_FORMAT);

        if (stringWithDivisionMark.contains(CUSTOM_DELIMITER_SUFFIX_FORMAT)) {
            return stringWithDivisionMark.substring(CUSTOM_DELIMITER_BEGIN_INDEX, endIndex);
        }
        throw new CalculatorException(WRONG_CUSTOM_DELIMITER_FORMAT);
    }

    private void validateNumber(String stringWithDivisionMark) {
        if (!stringWithDivisionMark.matches(NUMBER_INCLUDE_REGEX)) {
            throw new CalculatorException(WRONG_CUSTOM_DELIMITER_FORMAT);
        }
    }
}
