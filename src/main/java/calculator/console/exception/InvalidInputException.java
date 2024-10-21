package calculator.console.exception;

public class InvalidInputException extends IllegalArgumentException {

	public InvalidInputException(final String message) {
		super(ConsoleError.INVALID_INPUT_VALUE.getMessage() + message);
	}
}
