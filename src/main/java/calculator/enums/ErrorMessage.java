package calculator.enums;

public enum ErrorMessage {
    ONLY_NUMBER("구분자 사이에 숫자 이외의 문자는 입력될 수 없습니다."),
    SECOND_SEPARATOR_MISS("커스텀 구분자의 형식이 옳지 않습니다. \\n이 누락되었습니다."),
    NOT_ALLOW_SEPARATOR_OVER_TWO("//와 \\n 사이에는 하나의 구분자만 허용합니다."),
    MISS_SEPARATOR("구분자 없이 숫자가 연속으로 입력되었습니다. 숫자 사이에는 반드시 구분자가 필요합니다."),
    NOT_DEFINE_CUSTOM_SEPARATOR("커스텀 구분자 또는 기본 구분자만 사용할 수 있습니다."),
    NOT_ALLOW_ONLY_ZERO("숫자 0을 단독으로 입력할 수 없습니다."),
    NOT_ALLOW_DUPLICATION_SEPARATOR("구분자를 연속으로 사용할 수 없습니다."),
    NOT_ALLOW_BLANK("입력은 공백으로 시작할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
