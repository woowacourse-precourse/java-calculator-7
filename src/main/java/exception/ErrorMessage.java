package exception;

public enum ErrorMessage {
    NEGATIVE_NUMBER_NOT_ALLOWED("양수만 계산할 수 있습니다."),
    INVALID_NUMBERS_RANGE("정수의 범위가 정상적이지 않습니다."),
    INPUT_MUST_BE_NUMERIC("숫자만 계산할 수 있습니다."),
    DELIMITER_LENGTH_EXCEEDS_ONE("구분자의 길이는 1이어야 합니다."),
    INVALID_DELIMITER_TYPE("문자가 아닌 구분자가 입력되었습니다."),
    DUPLICATE_WITH_DEFAULT_DELIMITER("기본 구분자(쉼표, 콜론)와 중복되는 커스텀 구분자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
