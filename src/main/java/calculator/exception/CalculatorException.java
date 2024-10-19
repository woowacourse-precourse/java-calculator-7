package calculator.exception;

import calculator.exception.basic.CausedBy;
import calculator.exception.basic.GlobalException;

public class CalculatorException extends GlobalException {

    private final CalculatorErrorCode calculatorErrorCode;

    public CalculatorException(CalculatorErrorCode calculatorErrorCode) {
        super(calculatorErrorCode);
        this.calculatorErrorCode = calculatorErrorCode;
    }

    public CalculatorErrorCode getCalculatorErrorCode() {
        return calculatorErrorCode;
    }

    public CausedBy causedBy() {
        return calculatorErrorCode.causedBy();
    }
}
