package calculator.parser;

public enum ParserError {

	// Separator
	DUPLICATION_SEPARATOR("중복된 구분자입니다."),

	// MathematicalExpression
	INVALID_FORMAT_NUMBER("유효하지 않은 수의 형식입니다."),
	INVALID_MATHEMATICAL_EXPRESSION("유효하지 않은 수식입니다.");

	private final String message;

	ParserError(String s) {
		this.message=s;
	}

	public String getMessage(){
		return message;
	}

}
