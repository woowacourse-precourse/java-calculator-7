package calculator.exception.message;

public enum ExceptionMessage {
	NOT_NUMBER("숫자를 입력해주세요."),
	NOT_FOUND_CUSTOM_DELIMITER_END_SIGN("\\n을 찾을 수 없습니다."),
	INVALID_CUSTOM_PREFIX("잘못된 커스텀 구분자 형식입니다.");
	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
