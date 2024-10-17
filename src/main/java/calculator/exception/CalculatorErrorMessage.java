package calculator.exception;

public enum CalculatorErrorMessage {
    INVALID_CUSTOM_DELIMITER_SEPARATION_ERROR("커스텀 구분자 형식이 잘못되었습니다."),
    CONTAIN_DEFAULT_DELIMITER_ERROR("커스텀 구분자는 기본 구분자가 올 수 없습니다."),

    NOT_ALLOWED_CONTINUOUS_LETTER_ERROR("연속된 구분자는 불가능합니다."),
    NOT_ALLOWED_LETTER_ERROR("기본 구분자와 커스텀 구분자가 아닌 다른 문자를 입력할 수 없습니다."),
    INVALID_NUMBER_ERROR("숫자는 0과 음수가 아닌 양수만 가능합니다.");

    private final String errorMessage;

    CalculatorErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }
}
