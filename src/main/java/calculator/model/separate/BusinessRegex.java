package calculator.model.separate;

public enum BusinessRegex {
    CUSTOM_DELIMITER_COUNT_REGEX("(//.*?)\\\\n"),
    CUSTOM_DELIMITER_POSITION_REGEX("^(//.*?)\\\\n"),
    CUSTOM_DELIMITER_PARSE_REGEX("^//(.*?)\\\\n"),
    CUSTOM_DELIMITER_PARSE_CONDITION_REGEX("^//.*?")
    ;

    private final String value;

    BusinessRegex(String value) {
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

    public static String customDelimiterStartCondition() {
        return CUSTOM_DELIMITER_PARSE_CONDITION_REGEX.value;
    }
}
