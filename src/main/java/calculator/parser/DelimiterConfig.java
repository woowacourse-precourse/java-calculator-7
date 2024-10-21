package calculator.parser;

public enum DelimiterConfig {

    DEFAULT(",|:", "\\/\\/(.*)\\\\n(.*)");

    private final String defaultDelimiters;
    private final String customRegex;

    DelimiterConfig(String defaultDelimiters, String customRegex) {
        this.defaultDelimiters = defaultDelimiters;
        this.customRegex = customRegex;
    }

    public String getDefaultDelimiters() {
        return defaultDelimiters;
    }

    public String getCustomRegex() {
        return customRegex;
    }
}
