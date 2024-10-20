package calculator.controller;

public enum ExceptionMessage {
    INVALID_DELIMITER("기본 구분자와 일치하지 않는 문자가 존재합니다."),
    INVALID_CUSTOM_TYPE("잘못된 커스텀 구분자 형식입니다."),
    MUST_BE_DIGIT("문자열에 양의 정수만 포함되어야합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format() {
        return String.format(message);
    }
}