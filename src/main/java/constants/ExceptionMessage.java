package constants;

public enum ExceptionMessage {

    ENTER_VALID_DELIMITER_AND_POSITIVE_NUMBER("올바른 구분자와 양수를 입력해야 합니다."),
    ENTER_WITH_POSITIVE_NUMBER("양수도 함께 입력해야 합니다."),
    ENTER_WITH_VALID_DELIMITER("올바른 구분자도 함꼐 입력해야 합니다."),
    ENTER_POSITIVE_NUMBER("양수를 입력해야 합니다.");

    private String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
