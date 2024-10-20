package calculator.model.separate;

public enum RegexPattern {
    CUSTOM_DELIMITER_COUNT_REGEX("//.*?\\\\n"),
    CUSTOM_DELIMITER_PARSE_REGEX("^//(.*?)\\\\n"),
    WHITE_SPACE_REGEX("\\s"),
    OR_REGEX("|");

    private final String value;

    RegexPattern(String value) {
        this.value = value;
    }

    public static String customDelimiterCountRegex() {
        return CUSTOM_DELIMITER_COUNT_REGEX.value;
    }

    public static String customDelimiterParseRegex() {
        return CUSTOM_DELIMITER_PARSE_REGEX.value;
    }

    public static String replaceConditionRegex() {
        return CUSTOM_DELIMITER_PARSE_REGEX.value + OR_REGEX.value + WHITE_SPACE_REGEX.value;
    }
}
