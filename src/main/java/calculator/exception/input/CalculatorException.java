package calculator.exception.input;

public class CalculatorException extends IllegalArgumentException {

    public CalculatorException(CalculatorExceptionMessage calculatorExceptionMessage) {
        super(calculatorExceptionMessage.message);
    }
}
