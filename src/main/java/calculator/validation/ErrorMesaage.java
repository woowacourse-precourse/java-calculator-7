package calculator.validation;

public enum ErrorMesaage {
    CUSTOM_SEPARATOR_RULE("커스텀 구분자 생성 규칙을 위배했습니다."),
    CUSTOM_SEPARATOR_NUMBER("커스텀 구분자로 숫자는 올 수 없습니다."),
    NOT_ALLOWED_INPUT("숫자와 구분자 외 다른 문자는 올 수 없습니다."),
    SEPARATOR_BETWEEN_NUMBER("구분자와 구분자 사이에는 숫자가 와야합니다."),
    SEPARATOR_START("구분자가 먼저 올 수 없습니다."),
    SEPARATOR_END("구분자로 끝날 수 없습니다."),
    ZERO_IS_NOT_POSITIVE("0은 양수가 아닙니다.");

    private final String message;

    ErrorMesaage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
