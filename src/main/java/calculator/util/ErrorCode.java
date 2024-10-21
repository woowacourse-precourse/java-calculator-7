package calculator.util;

public enum ErrorCode {
    NUMBER_FORMAT_ERROR("숫자는 문자가 아니며 정수여야됩니다."),
    NUMBER_RANGE_ERROR("숫자는 양수여야됩니다."),
    SEPARATOR_ERROR("구분자는 숫자일 수 없습니다."),

    INPUT_ERROR("커스텀 구분자 문자열 형식이 올바르지 않습니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
