package calculator.enums;

public enum CustomDelimiter {
    CUSTOM_START("//"),
    CUSTOM_END("\\n");

    private final String customDelimiter;

    CustomDelimiter(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
