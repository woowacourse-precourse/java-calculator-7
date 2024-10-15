package calculator.exception;

public enum InputValidationException {
    TOO_LONG_STRING("입력된 문자열이 너무 깁니다. 100자 이내로 입력해주세요."),
    EMPTY_STRING("빈 문자열은 입력할 수 없습니다."),
    INVALID_CUSTOM_SEPARATOR_FORMAT("커스텀 구분자 형식이 올바르지 않습니다. '//[구분자]\\n' 형식으로 입력해주세요."),
    TOO_LONG_CUSTOM_SEPARATOR("커스텀 구분자가 너무 깁니다. 5자 이내로 입력해주세요."),
    EMPTY_CUSTOM_SEPARATOR("커스텀 구분자는 비어있을 수 없습니다."),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자 형식입니다. 1-20자리의 양의 정수만 입력 가능합니다."),
    NO_NUMBERS("숫자가 입력되지 않았습니다."),
    TOO_MANY_NUMBERS("숫자의 개수가 너무 많습니다. 1-100개의 숫자를 입력해주세요.");

    private final String message;

    InputValidationException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}