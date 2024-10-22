package calculator.model.validator;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;

public class DelimiterValidator {
    private String inputString;

    public DelimiterValidator(String inputString) {
        this.inputString = inputString;
    }

    public void validateFormat() {
        checkStartDelimiter();
        checkDelimiterPosition();
    }

    private void checkStartDelimiter() {
        if (inputString.startsWith("//") && !inputString.contains("\n")) {
            throw new CalculatorException(ErrorMessage.INVALID_FORMAT);
        }
    }

    private void checkDelimiterPosition() {
        if (!inputString.startsWith("//")) {
            throw new CalculatorException(ErrorMessage.INCORRECT_POSITION);
        }
    }
}
