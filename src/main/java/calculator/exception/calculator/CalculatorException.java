package calculator.exception.calculator;

public class CalculatorException extends IllegalArgumentException {

    public CalculatorException(CalculatorExceptionMessage calculatorExceptionMessage) {
        super(calculatorExceptionMessage.message);
    }
}
