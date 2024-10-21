package calculator.exception;

public enum ErrorMessage {

    IS_NOT_NUMBER("구분자 사이에 숫자가 들어있지 않습니다."),
    IS_NOT_CUSTOM_DELIMITER_PATTERN("커스텀 구분자 입력 형식과 일치하지 않습니다."),
    IS_NOT_POSITIVE("양수 이외의 값은 입력될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
