package calculator.exception;

public class OperationOutOfBoundsException extends IllegalArgumentException {

	public OperationOutOfBoundsException() {
		super(SystemError.OPERATION_OUT_OF_BOUNDS.getMessage());
	}
}
