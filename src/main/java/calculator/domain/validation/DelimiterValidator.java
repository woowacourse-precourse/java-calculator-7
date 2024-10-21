package calculator.domain.validation;

import static calculator.domain.errorMessage.ParseError.INCORRECT_POSITION;
import static calculator.domain.errorMessage.ParseError.INVALID_FORMAT;

import calculator.global.exception.CalculatorException;

public class DelimiterValidator {
    ;

    public void validateFormat(String inputString) {
        checkDelimiterPosition(inputString);
        checkStartDelimiter(inputString);
    }

    private void checkStartDelimiter(String inputString) {
        if (inputString.startsWith("//") && inputString.indexOf("\\n") != 3) {
            throw new CalculatorException(INVALID_FORMAT);
        }
    }

    private void checkDelimiterPosition(String inputString) {
        if (inputString.contains("//") && !inputString.startsWith("//")) {
            throw new CalculatorException(INCORRECT_POSITION);
        }
    }
}