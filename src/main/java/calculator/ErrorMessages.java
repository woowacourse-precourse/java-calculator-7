package calculator;

public enum ErrorMessages {
    NOT_EXIST_CUSTOM_DELIMITER_SUFFIX("커스텀 구분자의 끝이 존재하지 않습니다."),
    NOT_EXIST_CUSTOM_DELIMITER("커스텀 구분자가 존재하지 않습니다."),
    MULTI_CUSTOM_DELIMITER("커스텀 구분자는 한 개만 정의할 수 있습니다."),
    INVALID_CUSTOM_DELIMITER("구분자가 올바르지 않습니다."),
    NULL_INPUT("입력 값이 null입니다."),
    INVALID_NUMBER("숫자가 올바르지 않습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
