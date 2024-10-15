package calculator.parser;

public class InputParser {
    public static final String DEFAULT_DELIMETER_FILTER = "[,:]";
    public static final String DELIMITER_PREFIX = "//";
    public static final char DELIMITER_SUFFIX = '\n';

    public String[] separate(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            int startIndex = input.indexOf(DELIMITER_SUFFIX);
            String customDelimiter = input.substring(2, startIndex);
            String numbersPart = input.substring(startIndex + 1);
            return numbersPart.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMETER_FILTER);
    }
}
