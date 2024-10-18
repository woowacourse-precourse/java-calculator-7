package calculator.model.separate;

public enum RegexPattern {
    CUSTOM_DELIMITER_COUNT_REGEX("(//.*?)\\\\n"),
    CUSTOM_DELIMITER_POSITION_REGEX("^(//.*?)\\\\n"),
    CUSTOM_DELIMITER_PARSE_REGEX("^//(.*?)\\\\n"),
    CUSTOM_DELIMITER_PARSE_CONDITION_REGEX("^//.*?"),
    WHITE_SPACE_REGEX("\\s"),
    OR_REGEX("|");

    private final String value;

    RegexPattern(String value) {
        this.value = value;
    }

    public static String customDelimiterCountRegex() {
        return CUSTOM_DELIMITER_COUNT_REGEX.value;
    }

    public static String customDelimiterPositionRegex() {
        return CUSTOM_DELIMITER_POSITION_REGEX.value;
    }

    public static String customDelimiterParseRegex() {
        return CUSTOM_DELIMITER_PARSE_REGEX.value;
    }

    public static String customDelimiterStartConditionRegex() {
        return CUSTOM_DELIMITER_PARSE_CONDITION_REGEX.value;
    }

    public static String replaceConditionRegex() {
        return CUSTOM_DELIMITER_POSITION_REGEX.value + OR_REGEX.value + WHITE_SPACE_REGEX.value;
    }
}
