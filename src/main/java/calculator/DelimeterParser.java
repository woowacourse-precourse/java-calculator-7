package calculator;

public class DelimeterParser {

    private static final String DEFAULT_DELIMITERS = "[,|:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//.*\n";

    public static String[] parse(String input) {
        String delimiters = getDelimiter(input);
        String numbers = removeCustomDelimiterPrefix(input);
        System.out.println("delimiters = " + delimiters);
        return numbers.split(delimiters);
    }

    private static String getDelimiter(String input) {
        boolean hasCustomDelimiter = input.startsWith(CUSTOM_DELIMITER_START);

        if (hasCustomDelimiter) {
            int delimiterStartIndex = CUSTOM_DELIMITER_START.length();
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END);
            return input.substring(delimiterStartIndex, delimiterEndIndex);
        }

        return DEFAULT_DELIMITERS;
    }

    private static String removeCustomDelimiterPrefix(String input) {
        input = input.replace("\\n", "\n"); // to convert escape character to new line
        return input.replaceFirst(CUSTOM_DELIMITER_PREFIX, "");
    }
}
