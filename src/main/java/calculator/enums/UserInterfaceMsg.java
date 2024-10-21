package calculator.enums;

public enum UserInterfaceMsg {
    CALCULATOR_INTRO("문자열과 구분자를 입력하면, 문자열에서 양수들을 추출하여 더한 값을 출력합니다.\n"
            + "기본 구분자는 쉼표(,)와 콜론(:)을 가질 수 있으며,\n"
            + "커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용합니다.\n"
            + "음수를 입력하면 예외를 발생시킵니다.\n"
            + "덧셈할 문자열을 입력해 주세요"),
    CALC_RESULT("결과 : %d")
    ;

    private String value;
    UserInterfaceMsg(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
