package calculator.message;

public enum ErrorMessage {
    INVALID_NEGATIVE_NUM("양수 값을 입력해주십시오."),
    INVALID_LENGTH_DELIMITER("구분자는 한 글자만 가능합니다."),
    INVALID_WRONG_DELIMITER("구분자를 재확인 해주십시오.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
