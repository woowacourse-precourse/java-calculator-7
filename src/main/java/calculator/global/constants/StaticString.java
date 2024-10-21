package calculator.global.constants;

public enum StaticString {
	QUESTION_MESSAGE("덧셈할 문자열을 입력해 주세요.\n"),
	REGEX_PATTERN("^//(.)\\\\n(.*)$"),
	ERROR_MESSAGE("올바른 구분자가 아닙니다 -> "),
	ANSWER_MESSAGE("결과 : ");

	private final String message;

	StaticString(String message) {
		this.message = message;
	}

	public String getString() {
		return this.message;
	}
}
