package calculator.error;

public enum ErrorMessage {
    UNSUPPORTED_CUSTOM_DELIMITER_NUMBER("커스텀 구분자는 숫자일 수 없습니다."),
    UNSUPPORTED_NUMBER_EXCLUDE_POSITIVE("구분자를 제외한 문자에서 음수, 0 은 허용되지 않습니다."),
    UNSUPPORTED_CHAR_EXCLUDE_DELIMITER("구분자와 동일하지 않은 문자는 허용되지 않습니다."),
    CANNOT_EMPTY_DELIMITER("구분자는 공백일 수 없습니다."),
    CANNOT_EMPTY_TEXT("문자열은 공백일 수 없습니다.");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
