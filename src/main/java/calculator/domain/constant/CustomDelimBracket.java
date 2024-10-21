package calculator.domain.constant;

public enum CustomDelimBracket {
    OPEN("//"),
    CLOSE("\\n");

    private String bracket;

    CustomDelimBracket(String string) {
        bracket = string;
    }

    public String get() {
        return bracket;
    }
}
