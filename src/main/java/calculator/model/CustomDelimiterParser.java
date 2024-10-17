package calculator.model;

public class CustomDelimiterParser {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\\n";

    public static CustomDelimiterParser getInstance() {
        return new CustomDelimiterParser();
    }

    public String parse(String input) {
        return "";
    }
}
