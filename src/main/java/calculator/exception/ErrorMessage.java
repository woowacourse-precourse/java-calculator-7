package calculator.exception;

public enum ErrorMessage {
    NEGATIVE_NUMBER("음수는 허용되지 않습니다: %s"),
    INVALID_NUMBER("숫자가 아닌 값이 포함되어 있습니다: %s"),
    INVALID_LENGTH("커스텀 구분자의 길이는 1이어야 합니다."),
    DIGIT_NOT_ALLOWED("커스텀 구분자는 숫자가 될 수 없습니다."),
    DUPLICATE_DELIMITER("커스텀 구분자는 기본 구분자와 중복될 수 없습니다."),
    OUT_OF_RANGE("계산 결과가 표현 범위를 초과했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}