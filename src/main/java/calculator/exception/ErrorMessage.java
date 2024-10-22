package calculator.exception;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    NOT_A_NUMBER_INPUT("입력값은 숫자여야 합니다."),
    CUSTOM_DIVIDER_DIGIT("커스텀 구분자는 문자여야 합니다."),
    CUSTOM_INPUT_ERROR("커스텀 구분자 입력 형식이 잘못되었습니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
