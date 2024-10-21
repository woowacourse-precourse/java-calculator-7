package calculator.domain.validator;

import static calculator.domain.constant.Delimiter.CUSTOM_END;
import static calculator.domain.constant.Delimiter.CUSTOM_START;
import static calculator.domain.constant.errorMessage.ParseError.INCORRECT_POSITION;
import static calculator.domain.constant.errorMessage.ParseError.INVALID_FORMAT;
import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;

import calculator.global.exception.CalculatorException;

public class InputValidator {

    private static final String CUSTOM_DELIMITER_START = CUSTOM_START.getDelimiter();
    private static final String CUSTOM_DELIMITER_END = CUSTOM_END.getDelimiter();

    public void validateFormat(String inputString) {
        checkStartDelimiter(inputString);
        checkDelimiterPosition(inputString);
    }

    public static void validateNoInternalWhitespace(String token) {
        if (token.contains(" ")) {
            throw new CalculatorException(INVALID_VALUE_FORMAT);
        }
    }

    private void checkStartDelimiter(String inputString) {

        int startDelimiterIndex = inputString.indexOf(CUSTOM_DELIMITER_START);
        int endDelimiterIndex = inputString.indexOf(CUSTOM_DELIMITER_END);

        if (startDelimiterIndex == 0 && (endDelimiterIndex != CUSTOM_DELIMITER_START.length() + 1)) {
            throw new CalculatorException(INVALID_FORMAT);
        }

        if (endDelimiterIndex == 0 && (startDelimiterIndex != CUSTOM_DELIMITER_START.length() + 1)) {
            throw new CalculatorException(INVALID_FORMAT);
        }
    }

    private void checkDelimiterPosition(String inputString) {
        int startDelimiterIndex = inputString.indexOf(CUSTOM_DELIMITER_START);
        int endDelimiterIndex = inputString.indexOf(CUSTOM_DELIMITER_END);

        if ((startDelimiterIndex > 1 && endDelimiterIndex == -1) || (endDelimiterIndex > 1
                && startDelimiterIndex == -1)) {
            throw new CalculatorException(INCORRECT_POSITION);
        }
    }
}
