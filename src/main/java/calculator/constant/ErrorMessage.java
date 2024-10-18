package calculator.constant;

import java.util.List;

public enum ErrorMessage {
	NUMBERS_POSITIVE("양수 값만 계산할 수 있습니다."),
	NUMBERS_NUMBER_FORMAT("숫자만 계산할 수 있습니다."),
	NUMBERS_OVERFLOW("지원하지 않는 값의 범위입니다."),
	DELIMITER_LENGTH("구분자의 길이는 1 이어야 합니다."),
	DELIMITER_NOT_NUMBER("구분자는 숫자가 될 수 없습니다."),
	NUMBER_SEPARATOR_EQUATION("올바르지 않은 입력 형식입니다.");

	private static final String SPACE = " ";
	private static final String PREFIX = "[ERROR] ";
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return String.join(SPACE, PREFIX, this.message);
	}
}
