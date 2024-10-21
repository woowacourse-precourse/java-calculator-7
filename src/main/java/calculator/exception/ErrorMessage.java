package calculator.exception;

public enum ErrorMessage {

    INCORRECT_REGEX("올바르지 않은 입력 형식입니다."),

    CUSTOM_LENGTH_IS_FIX("커스텀 구분자는 %d글자만 입력해야 합니다."),
    CUSTOM_TYPE_IS_NOT_NUMBER("커스텀 구분자에 숫자는 입력할 수 없습니다."),
    CUSTOM_CANT_BE_DEFAULT("기본 구분자는 커스텀으로 사용할 수 없습니다."),
    IS_NOT_CUSTOMIZED("지정한 구분자 외의 문자는 입력할 수 없습니다."),

    NUMBERS_ONLY_POSITIVE("양수만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
