package calculator.exception;

public class NegativeValueException extends IllegalArgumentException {
	public NegativeValueException() {
		super(SystemError.NEGATIVE_NUMBER.getMessage());
	}
}
