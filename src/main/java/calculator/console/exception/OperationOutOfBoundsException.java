package calculator.console.exception;

public class OperationOutOfBoundsException extends IllegalArgumentException {

	public OperationOutOfBoundsException() {
		super(ConsoleError.OPERATION_OUT_OF_BOUNDS.getMessage());
	}
}
