package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {

	public InvalidInputException(final String message) {
		super(SystemError.INVALID_INPUT_VALUE.getMessage() + message);
	}
}
