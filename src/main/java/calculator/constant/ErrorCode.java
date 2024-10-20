package calculator.constant;

public enum ErrorCode {
    INVALID_CUSTOM_DELIMITER("커스텀 구분자 설정이 잘못 되었습니다."),
    ONLY_POSITIVE_NUMBERS_ALLOWED("숫자는 양수만 가능합니다."),
    ONLY_NUMBERS_ALLOWED("문자가 아닌 숫자만 입력이 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
