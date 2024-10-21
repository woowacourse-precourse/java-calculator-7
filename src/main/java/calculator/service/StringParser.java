package calculator.service;

public class StringParser {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] parseString(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = findCustomDelimiter(input);
            String delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            return splitString(input.substring(input.indexOf("\\n") + 2), delimiters);
        }

        return splitString(input, DEFAULT_DELIMITERS);
    }

    private String findCustomDelimiter(String input) {
        int endIndex = input.indexOf("\\n");
        return input.substring(2, endIndex);
    }

    private String[] splitString(String input, String delimiters) {
        return input.split(delimiters);
    }
}
