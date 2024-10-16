package calculator.view;

public enum ErrorMessage {

    EMPTY_INPUT_ERROR("입력이 비어있습니다."),
    NON_NUMERIC_INPUT_ERROR("숫자가 아닌 문자가 포함되었습니다."),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다: "),
    INVALID_CUSTOM_DELIMITER_ERROR("잘못된 커스텀 구분자 형식입니다."),
    INVALID_DELIMITER_FORMAT_ERROR("커스텀 구분자가 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}