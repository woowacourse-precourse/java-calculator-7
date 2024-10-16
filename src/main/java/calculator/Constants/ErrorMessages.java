package calculator.Constants;

public enum ErrorMessages {
    ERROR_PREFIX("[ERROR] "),
    INVALID_STRING_MESSAGE("문자열만 입력할 수 있습니다."),
    INVALID_NUMBER_RANGE_MESSAGE("양수만 입력할 수 있습니다."),
    INVALID_NUMBER_MESSAGE("숫자가 아닙니다."),
    INVALID_NUMBERS_EMPTY_MESSAGE("숫자들은 비어있을 수 없습니다."),
    INVALID_CUSTOM_INDICATOR_MESSAGE("유효하지 않은 커스텀 구분자 지시자입니다."),
    INVALID_CUSTOM_SEPARATOR_BLANK_MESSAGE("잘못된 커스텀 구분자 입니다.(공백)"),
    INVALID_CUSTOM_SEPARATOR_EMPTY_MESSAGE("잘못된 커스텀 구분자 입니다.(비어있음)"),
    INVALID_CUSTOM_SEPARATOR_DIGIT_MESSAGE("잘못된 커스텀 구분자 입니다.(숫자)");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX.message + message;
    }
}
