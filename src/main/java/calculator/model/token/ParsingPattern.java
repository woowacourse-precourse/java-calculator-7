package calculator.model.token;

public enum ParsingPattern {
    DEFAULT_DELIMITER_PATTERN(",|:"),
    DELIMITER_TOKEN_HEADER("//"),
    DELIMITER_TOKEN_FOOTER("\\n"),
    DELIMITER_TOKEN_SPLIT_PATTERN("\\\\n"),
    DELIMITER_TOKEN_INDEX(0),
    NUMBERS_TOKEN_SPLIT_PATTERN("\\\\n"),
    NUMBERS_TOKEN_INDEX(1),
    NUMBERS_TOKEN_SPLIT_LIMIT(-1),
    NUMBER_SPLIT_LIMIT(-1);

    private String pattern;
    private int number;

    ParsingPattern(String pattern) {
        this.pattern = pattern;
    }

    ParsingPattern(int number) {
        this.number = number;
    }


    public String getPattern() {
        return pattern;
    }

    public int getNumber() {
        return number;
    }
}
