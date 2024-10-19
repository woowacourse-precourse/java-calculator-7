package calculator.global.message;

public enum ErrorMessage {
    NULL_INPUT_ERROR("null은 입력할 수 없습니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("'//'와 '\n'이 모두 존재해야 합니다."),
    INVALID_CUSTOM_DELIMITER_ORDER("'//'는 '\n'보다 앞에 위치해야 합니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자가 비어 있습니다."),
    INVALID_CUSTOM_DELIMITER_LENGTH("커스텀 구분자는 문자 1개로 구성되어야 합니다."),
    CUSTOM_DELIMITER_IS_NUMBER("커스텀 구분자는 숫자가 될 수 없습니다.");;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}