package calculator.enums;

public enum CustomExceptionMessage {
    FIND_NOT_INTEGER("지정된 구분자 외 문자는 사용할 수 없습니다.");

    private final String message;

    CustomExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}