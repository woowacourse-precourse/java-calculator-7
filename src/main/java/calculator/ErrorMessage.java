package calculator;

public enum ErrorMessage {

    INCORRECT_NUMBER_TYPE("계산할 값이 숫자 타입이 아닙니다."),
    INVALID_POSITIVE_INPUT("계산할 값이 양수가 아닙니다."),
    INVALID_NUMERIC_INPUT("숫자는 구분자로 사용할 수 없습니다."),
    INVALID_FORMAT_REGISTER_DELIMITER("커스텀 구분자 등록 형식이 올바르지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
