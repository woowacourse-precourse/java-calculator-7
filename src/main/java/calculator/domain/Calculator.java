package calculator.domain;

import calculator.exception.input.CalculatorException;

import static calculator.exception.input.CalculatorExceptionMessage.WRONG_CUSTOM_DELIMITER_FORMAT;

public class Calculator {

    private static final String COMMA = ",";
    private static final String COLON = ";";
    private static final String CUSTOM_DELIMITER_PREFIX_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX_FORMAT = "\n";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;

    public String getCustomDivisionMark(String stringWithDivisionMark) {
        if (isRightCustomDelimiterFormat(stringWithDivisionMark)) {
            return stringWithDivisionMark.substring(CUSTOM_DELIMITER_BEGIN_INDEX, stringWithDivisionMark.indexOf(CUSTOM_DELIMITER_SUFFIX_FORMAT));
        }
        throw new CalculatorException(WRONG_CUSTOM_DELIMITER_FORMAT);
    }

    private boolean isRightCustomDelimiterFormat(String stringWithDivisionMark) {
        return stringWithDivisionMark.startsWith(CUSTOM_DELIMITER_PREFIX_FORMAT)
                && stringWithDivisionMark.contains(CUSTOM_DELIMITER_SUFFIX_FORMAT);
    }
}
