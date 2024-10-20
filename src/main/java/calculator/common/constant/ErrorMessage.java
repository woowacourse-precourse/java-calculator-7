package calculator.common.constant;

public enum ErrorMessage {
    INPUT_MUST_NOT_CONTAIN_BLANK("입력 시 공백이 있어서는 안됩니다."),
    CALCULATE_ONLY_NUMBERS("숫자만 계산할 수 있습니다."),
    NUMBERS_RANGE("숫자는 0 ~ 9223372036854775807 사이의 값이어야 합니다."),
    DELIMITER_MUST_BE_CHARACTER("커스텀 구분자는 문자만 지정할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
