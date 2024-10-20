package calculator;

public enum ErrorMessage {

    NOT_FOUND_CUSTOM_DELIMITER("커스텀 구분자가 입력되지 않았습니다."),
    OUT_OF_RANGE_CUSTOM_DELIMITER("커스텀 구분자가 2글자 이상입니다."),
    CUSTOM_DELIMITER_FORMAT_ERROR("커스텀 구분자로 숫자를 사용할 수 없습니다."),
    NEGATIVE_NUMBER_NOT_ALLOWED("음수는 입력되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
