package calculator.domain.validation;

import static calculator.domain.errorMessage.parseError.INVALID_FORMAT;

import calculator.global.exception.CalculatorException;

public class DelimiterValidator {
    private String inputString;

    public DelimiterValidator(String inputString) {
        this.inputString = inputString;
    }

    public void validateFormat() {
        checkStartDelimiter();
    }

    private void checkStartDelimiter() {
        if (inputString.startsWith("//") && !inputString.contains("\\n")) {
            throw new CalculatorException(INVALID_FORMAT);
        }
    }
}