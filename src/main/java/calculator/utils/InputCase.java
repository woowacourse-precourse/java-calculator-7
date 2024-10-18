package calculator.utils;

public enum InputCase {
    NONE("미입력"),
    DEFAULT("기본"),
    CUSTOM("커스텀");

    private final String str;

    private InputCase(String str) {
        this.str = str;
    }

    public String getValue() {
        return str;
    }

}
