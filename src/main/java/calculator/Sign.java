package calculator;

public enum Sign {
    CUSTOM_SEPARATOR_PRE_SIGN("//"),
    CUSTOM_SEPARATOR_POST_SIGN("\\n"),
    OR("|"),
    BRACKET_OPEN("["),
    BRACKET_CLOSE("]");

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
