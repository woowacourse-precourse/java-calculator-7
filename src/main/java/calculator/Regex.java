package calculator;

public enum Regex {
    DEFAULT_SEPARATOR_REGEX(",|:"),
    NUMBER_REGEX("\\d+"),
    SPECIAL_CHARACTER_REGEX("[\\.\\*\\+\\^\\$\\[\\]\\{\\}\\(\\)\\|\\\\\\?]");

    private final String value;

    Regex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
