package calculator.exception;

import calculator.system.SystemMessages;

public class InvalidInputException extends IllegalArgumentException {

	public InvalidInputException(final String message) {
		super(SystemMessages.INVALID_INPUT_VALUE.getMessage() + message);
	}
}
