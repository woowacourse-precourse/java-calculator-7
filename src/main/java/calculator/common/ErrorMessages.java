package calculator.common;

public enum ErrorMessages {
	SEPARATOR_NOT_ALLOWED("잘못된 구분자 처리입니다"),
	CUSTOM_SEPARATOR_PREFIX("커스텀 구분자는 '//'로 시작해야 합니다"),
	CUSTOM_SEPARATOR_LENGTH("커스텀 구분자는 단일 문자여야 합니다"),
	CUSTOM_SEPARATOR_NUMERIC("커스텀 구분자에 숫자가 포함될 수 없습니다"),
	;

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
