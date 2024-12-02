package calculator;

public enum Regex {
    DEFAULT_SEPARATOR_REGEX(",|:"),
    CUSTOM_SEPARATOR_REGEX("//.\\n."),
    START_WITH_NUMBER_REGEX("\\d+"),
    SPECIAL_CHARACTER_REGEX("[\\.\\*\\+\\^\\$\\[\\]\\{\\}\\(\\)\\|\\\\\\?]");

    private final String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
