package calculator.exception.message;

public enum ExceptionMessage {
	NOT_NUMBER("숫자를 입력해주세요."),
	NOT_FOUND_CUSTOM_DELIMITER_END_SIGN("\\n을 찾을 수 없습니다."),
	INVALID_CUSTOM_PREFIX("잘못된 커스텀 구분자 형식입니다."),
	NOT_POSITIVE_NUMBER("음수가 포함되어 있습니다."),
	OUT_OF_BOUNDS("범위를 벗어난 숫자가 입력되었습니다.");
	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
