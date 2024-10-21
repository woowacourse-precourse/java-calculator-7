package calculator.exception;

public enum ErrorMessage {

	// prefix
	ERROR_PREFIX("[ERROR] "),

	// delimiter
	INVALID_DELIMITER("허용되지 않은 구분자가 포함되어 있습니다."),
	INVALID_CUSTOM_DELIMITER("커스텀 구분자는 정수일 수 없습니다."),
	EMPTY_CUSTOM_DELIMITER("커스텀 구분자는 빈 문자열일 수 없습니다."),

	// calculator
	NON_INTEGER_VALUE("계산기에 입력될 숫자는 정수이어야 합니다."),
	NON_POSITIVE_NUMBER("계산기에 입력될 숫자는 양수이어야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR_PREFIX.message + message;
	}
}
