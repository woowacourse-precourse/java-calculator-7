package calculator.exception.util;

public enum CustomDelimiterExtractorErrorMessage {
    INVALID_CUSTOM_DELIMITER_FORMAT("잘못된 구분자 형식입니다."),
    CUSTOM_DUPLICATE_CUSTOM_DELIMITER("기본 구분자와 중복된 커스텀 구분자입니다."),
    CUSTOM_DELIMITER_IS_SPACE("구분자가 공백입니다."),
    CUSTOM_DELIMITER_IS_EMPTY("구분자가 비어있습니다.");

    private final String message;

    CustomDelimiterExtractorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
