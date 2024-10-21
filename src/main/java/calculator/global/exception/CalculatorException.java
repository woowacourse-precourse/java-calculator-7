package calculator.global.exception;


import calculator.global.globalEnum.Message;

public class CalculatorException extends IllegalArgumentException {
    public CalculatorException(Message errorMessage) {
        super(errorMessage.getMessage());
    }
}