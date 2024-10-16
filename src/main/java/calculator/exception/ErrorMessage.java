package calculator.exception;

public enum ErrorMessage {

    NOT_MATCH_FOUND("매칭되는 구분자가 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}