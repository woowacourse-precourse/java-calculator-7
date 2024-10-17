package calculator.utils;

public enum ErrorMessage {
    NULL_NOT_ALLOWED("null 값은 허용되지 않는다."),
    ONLY_POSITIVE_NUMBERS_ALLOWED("음수를 제외한 숫자 값만 입력 가능하다."),
    CUSTOM_DELIMITER_START_POINT_NOT_ALLOWED("커스텀 구분자는 // 로 시작해야 한다."),
    CUSTOM_DELIMITER_END_POINT_NOT_ALLOWED("커스텀 구분자는 // 로 시작해서 \\n 으로 끝나야 한다."),
    EMPTY_STRING_IS_NOT_ALLOWED("커스텀 구분자로 빈 값을 사용 할 수 없다."),
    INVALID_DELIMITER("구분자가 적절하지 않다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
