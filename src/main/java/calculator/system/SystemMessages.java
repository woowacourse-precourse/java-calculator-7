package calculator.system;

public enum SystemMessages {
	INVALID_INPUT_VALUE("유효한 입력값이 아닙니다.");

	private final String message;

	SystemMessages(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
