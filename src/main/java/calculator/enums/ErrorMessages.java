package calculator.enums;

public enum ErrorMessages {
    EMPTY_INPUT("입력값이 비어있습니다."),
    MISSING_NEWLINE("\\n 가 존재하지 않습니다."),
    MISSING_CUSTOM_DELIMITER("커스텀 구분자가 존재하지 않습니다."),
    NEGATIVE_NUMBER("음수는 허용되지 않습니다: "),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자 형식입니다: ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
