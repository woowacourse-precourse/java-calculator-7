package calculator.global.constants;

public enum StaticMessage {

	QUESTION_MESSAGE("덧셈할 문자열을 입력해 주세요.\n");

	private final String message;

	StaticMessage(String message) {
		this.message = message;
	}

	private String getMessage() {
		return this.message;
	}
}
