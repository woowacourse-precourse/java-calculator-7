package calculator.console;

public enum ConsolePrefix {
	INPUT_REQUEST_PREFIX("덧셈할 문자열을 입력해 주세요."),
	RESULT_RESPONSE_PREFIX("결과 : ");

	private final String message;

	ConsolePrefix(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
