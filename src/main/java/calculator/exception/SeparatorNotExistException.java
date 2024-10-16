package calculator.exception;

public class SeparatorNotExistException extends RuntimeException {
	public SeparatorNotExistException(String firstFiveCharacters) {
		super(firstFiveCharacters + "에는 구분자를 정의하고 있지 않습니다.");
	}
}
