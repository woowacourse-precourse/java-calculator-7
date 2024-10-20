package calculator.exception;

import calculator.system.SystemMessages;

public class OperationOutOfBoundsException extends IllegalArgumentException {

	public OperationOutOfBoundsException() {
		super(SystemMessages.OPERATION_OUT_OF_BOUNDS.getMessage());
	}
}
