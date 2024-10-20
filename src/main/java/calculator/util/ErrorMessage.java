package calculator.util;

public enum ErrorMessage {
    INVALID_POSITIVE_NUMBER("[ERROR] 양수만 입력해주세요"),
    INVALID_DIGIT("[ERROR] 숫자만 입력해주세요"),
    INVALID_CUSTOM_DELIMITER_FORMAT("[ERROR] 커스텀 구분자형식에 맞춰서 입력해주세요."),
    INVALID_FORMAT("[ERROR] 형식에 맞춰서 입력해주세요"),
    DUPLICATE_DELIMITER("[ERROR] 이미 추가한 구분자는 custom으로 지정할 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
