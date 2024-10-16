package calculator.validator;

import calculator.exception.calculator.CalculatorException;

import static calculator.exception.calculator.CalculatorExceptionMessage.MINUS_OR_ZERO_NUMBER;

public class CalculatorValidator {

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9][0-9]*";

    //TODO: 양수, 구분자외의 문자열 예외처리 분리
    public void validatePositivity(String str) {
        if (!str.matches(POSITIVE_NUMBER_REGEX)) {
            throw new CalculatorException(MINUS_OR_ZERO_NUMBER);
        }
    }
}
