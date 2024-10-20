package calculator.exception;

public class InvalidSeparatorException extends RuntimeException {
	public InvalidSeparatorException(Character separator) {
		super(separator + "는 유효하지 않은 구분자입니다.");
	}
}
