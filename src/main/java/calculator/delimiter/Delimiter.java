package calculator.delimiter;

public class Delimiter {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final String customDelimiter;

    public Delimiter(String line) {
        customDelimiter = readDelimiter(line);
    }

    private String readDelimiter(String line) {
        String delimiterLine = getDelimiterLine(line);
        return removeWords(delimiterLine, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
    }

    private String removeWords(String original, String... words) {
        String result = original;
        for (String word : words) {
            result = result.replace(word, "");
        }
        return result;
    }

    private String getDelimiterLine(String line) {
        return line.substring(0, findEndOfDelimiterLineIndex(line));
    }

    private int findEndOfDelimiterLineIndex(String line) {
        if (line.contains(CUSTOM_DELIMITER_SUFFIX))
            return line.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        return 0;
    }

    public String[] split(String line) {
        if(hasCustomDelimiter())
            return line.split(customDelimiter);
        return line.split(DEFAULT_DELIMITER_REGEX);
    }

    private boolean hasCustomDelimiter() {
        return !customDelimiter.isEmpty();
    }
}
