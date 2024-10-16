package calculator.parser;

public enum ParserError {

	// Separator
	DUPLICATION_SEPARATOR("중복된 구분자입니다."),
	INVALID_FORMAT_SEPARATOR("잘못된 커스텀 구분자 형식입니다."),

	// MathematicalExpression
	INVALID_POSITIVE_NUMBER("양수가 아닌 값입니다."),
	INVALID_FORMAT_NUMBER("잘못된 수의 형식입니다.");

	private final String message;

	ParserError(String s) {
		this.message=s;
	}

	public String getMessage(){
		return message;
	}

}
