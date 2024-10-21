package calculator.console.exception;

enum ConsoleError {

	INVALID_INPUT_VALUE("유효한 입력값이 아닙니다."),
	OPERATION_OUT_OF_BOUNDS("계산 결과가 허용 범위를 벗어났습니다.");

	private final String message;

	ConsoleError(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
