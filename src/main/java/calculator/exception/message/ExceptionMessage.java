package calculator.exception.message;

public enum ExceptionMessage {
	NOT_NUMBER("숫자를 입력해주세요.");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
