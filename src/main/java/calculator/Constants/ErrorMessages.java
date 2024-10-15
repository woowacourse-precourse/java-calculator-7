package calculator.Constants;

public enum ErrorMessages {
    ERROR_PREFIX("[ERROR] "),
    INVALID_STRING_MESSAGE("문자열만 입력할 수 있습니다."),
    INVALID_BLANK_MESSAGE("공백은 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE_MESSAGE("양수만 입력할 수 있습니다."),
    INVALID_NUMBERS_EMPTY_MESSAGE("숫자들은 비어있을 수 없습니다."),
    INVALID_SEPARATOR_MESSAGE("잘못된 기본 구분자 입니다."),
    INVALID_CUSTOM_INDICATOR_MESSAGE("// 및 \\n 이외의 커스텀 구분자 지시자를 사용할 수 없습니다."),
    INVALID_CUSTOM_SEPARATOR_MESSAGE("잘못된 커스텀 구분자 입니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX.message + message;
    }
}
