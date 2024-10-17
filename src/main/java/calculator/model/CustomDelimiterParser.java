package calculator.model;

public class CustomDelimiterParser {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\\n";

    public static CustomDelimiterParser getInstance() {
        return new CustomDelimiterParser();
    }

    public String parse(String input) {
        if (hasCustomDelimiter(input)) {
            return input.substring(PREFIX.length(), getSuffixIndex(input));
        }
        return "";
    }

    public boolean hasCustomDelimiter(String input) {
        if (!input.startsWith(PREFIX)) {
            return false;
        }
        int suffixIndex = getSuffixIndex(input);
        return suffixIndex != -1;
    }

    private int getSuffixIndex(String input) {
        return input.indexOf(SUFFIX);
    }
}
