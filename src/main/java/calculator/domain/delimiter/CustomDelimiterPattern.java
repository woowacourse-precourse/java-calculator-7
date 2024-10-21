package calculator.domain.delimiter;

public enum CustomDelimiterPattern {
    CUSTOM_DELIMITER_START("//"),
    CUSTOM_DELIMITER_END("\\n");

    private final String pattern;

    CustomDelimiterPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
