package calculator.system;

public enum SystemMessages {
	INVALID_INPUT_VALUE("유효한 입력값이 아닙니다."),
	OPERATION_OUT_OF_BOUNDS("계산 결과가 허용 범위를 벗어났습니다."),
	INPUT_REQUEST_PREFIX("덧셈할 문자열을 입력해 주세요."),
	RESULT_RESPONSE_PREFIX("결과 : ");

	private final String message;

	SystemMessages(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
