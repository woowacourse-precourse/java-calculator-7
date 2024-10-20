package calculator.constant;

public enum ErrorMessage {

	INVALID_CUSTOM_DELIMITER_FORMAT("지정된 형식을 지켜주세요. ex)//+\\n1+2+3"),
	USE_CUSTOM_DELIMITER_PREFIX_AT_CUSTOM_DELIMITER("커스텀 구분자 지정을 위한 문자(//)는 커스텀 구분자로 사용할 수 없습니다."),
	USE_NUMBER_AT_CUSTOM_DELIMITER("숫자는 커스텀 구분자로 사용할 수 없습니다."),
	USE_BLANK_OR_CUSTOM_DELIMITER_SUFFIX_AT_CUSTOM_DELIMITER("빈 문자열이나 커스텀 구분자 지정을 위한 문자(\\n)는 커스텀 구분자로 사용할 수 없습니다."),
	INVALID_NUMBER_FORMAT("구분자 사이에는 숫자만 사용할 수 있습니다. ex) 1,2,3"),
	START_WITH_DELIMITER("구분자로 시작할 수 없습니다. ex) 1,2,3"),
	END_WITH_DELIMITER("구분자로 끝날 수 없습니다. ex) 1,2,3"),
	USE_CONTINUOUS_DELIMITER("연속된 구분자는 사용할 수 없습니다. ex) 1,2,3"),
	USE_UNREGISTERED_DELIMITER("등록되지 않은 구분자는 사용할 수 없습니다 -> "),
	NEGATIVE_NUMBER_NOT_ALLOWED("음수는 사용할 수 없습니다."),
	OVER_FLOW_INPUT_VALUE("정해진 범위를 초과한 숫자가 입력되었습니다.")
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
