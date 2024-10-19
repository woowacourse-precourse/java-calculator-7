package parser;

public class DelimiterParser {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public String parseDelimiters(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(2, delimiterEndIndex);
        }
        return DEFAULT_DELIMITERS;
    }
}
