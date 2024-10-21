package calculator.view;

public enum PrintMessage {
	READ_COMMAND("덧셈할 문자열을 입력해 주세요."),
	RESULT("결과 : %d");

	private final String message;

	PrintMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
