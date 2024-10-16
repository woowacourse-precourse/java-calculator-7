package calculator;

public enum PrintText {
    START_TEXT("덧셈할 문자열을 입력해 주세요."),
    RESULT_TEXT("결과 : "),
    CUSTOM_DEL_PRE_SEPERATOR("//"),
    CUSTOM_DEL_POST_SEPERATOR("\\n"),
    COMMA(","),
    COLON(":");

    private final String value;

    PrintText(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }
}