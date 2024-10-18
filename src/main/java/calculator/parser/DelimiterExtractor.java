package calculator.parser;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private int beginIndex;

    public String getDefaultDelimiter() {
        return DEFAULT_DELIMITER;
    }

    public String extractCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int delimiterEnd = input.indexOf("\\n");
        setBeginIndex(delimiterEnd);
        return input.substring(startIndex, delimiterEnd);
    }

    private void setBeginIndex(int delimiterEnd) {
        beginIndex = delimiterEnd + 2;
    }

    public int getBeginIndex() {
        return beginIndex;
    }
}
