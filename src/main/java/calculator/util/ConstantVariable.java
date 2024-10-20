package calculator.util;

public enum ConstantVariable {
    PROGRAM_START("덧셈할 문자열을 입력해 주세요."),
    PROGRAM_END_RESULT("결과 : "),
    ;

    private final String value;

    ConstantVariable(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
