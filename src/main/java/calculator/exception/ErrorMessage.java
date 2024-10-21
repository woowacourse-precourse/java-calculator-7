package calculator.exception;

public enum ErrorMessage {
	INVALID_INPUT("입력을 숫자로 변환할 수 없거나, 변환된 값이 long 범위를 초과합니다."),
	NEGATIVE_NUMBER("입력은 음수일 수 없습니다."),
	NULL_OR_EMPTY_INPUT("입력이 null이거나 비어있습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}