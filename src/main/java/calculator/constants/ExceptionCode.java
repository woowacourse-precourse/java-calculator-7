package calculator.constants;

public enum ExceptionCode {

    NULL_INPUT("입력 값이 없습니다."),
    NEGATIVE_OR_ZERO_INPUT("0 또는 음수가 포함되어 있습니다."),

    VALID_NUMBER("숫자가 아닌 값이 포함되어 있습니다."),

    VAILDATION_CUSTOME("커스텀 구분자가 올바르게 입력되지 않았습니다."),
    VAILDATION_CUSTOME_SIZE("커스텀 구분자의 크기가 2이상 입니다.");


    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
