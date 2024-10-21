package calculator.exception;

public enum ErrorMessage {

	ERROR_PREFIX("[ERROR] "),
	INVALID_DELIMITER("허용되지 않은 구분자가 포함되어 있습니다."),
	NON_INTEGER_VALUE("구분자 사이에 정수가 아닌 값이 포함되어 있습니다."),
	INVALID_CUSTOM_DELIMITER("커스텀 구분자는 정수일 수 없습니다."),
	NON_POSITIVE_NUMBER("계산기에 입력될 숫자는 양수이어야 합니다."),
	EMPTY_CUSTOM_DELIMITER("커스텀 구분자는 빈 문자열일 수 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR_PREFIX.message + message;
	}
}
