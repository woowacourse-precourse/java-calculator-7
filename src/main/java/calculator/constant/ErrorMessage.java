package calculator.constant;

public enum ErrorMessage {

	INVALID_CUSTOM_DELIMITER_FORMAT("지정된 형식을 지켜주세요. ex)//+\\n1+2+3"),
	USE_CUSTOM_DELIMITER_PREFIX_AT_CUSTOM_DELIMITER("커스텀 구분자 지정을 위한 문자(//)는 커스텀 구분자로 사용할 수 없습니다."),
	USE_NUMBER_AT_CUSTOM_DELIMITER("숫자는 커스텀 구분자로 사용할 수 없습니다."),
	USE_BLANK_OR_CUSTOM_DELIMITER_SUFFIX_AT_CUSTOM_DELIMITER("빈 문자열이나 커스텀 구분자 지정을 위한 문자(\\n)는 커스텀 구분자로 사용할 수 없습니다."),
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
