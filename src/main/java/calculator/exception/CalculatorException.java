package calculator.exception;

import calculator.constant.ExceptionConstant;
import calculator.exception.message.ExceptionMessage;

public class CalculatorException extends IllegalArgumentException{
	public CalculatorException(ExceptionMessage errorMessage){
		super(ExceptionConstant.ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
	}
}
