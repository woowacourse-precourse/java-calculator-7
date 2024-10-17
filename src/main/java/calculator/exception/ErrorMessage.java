package calculator.exception;

public enum ErrorMessage {

    NOT_MATCH_FOUND_DELIMITER("매칭되는 구분자가 없습니다."),
    INVALID_INPUT("구분자와 숫자를 정확하게 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}