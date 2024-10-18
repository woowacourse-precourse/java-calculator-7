package calculator.model;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    private String delimiter = ",|:";
    private int contentStartIndex;
    private static final int DELIMITER_START = 2;

    public void addCustomDelimiter(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        delimiter += "|" + Pattern.quote(customDelimiter);
    }

    public String extractCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf("\\n");
        setContentStartIndex(delimiterEnd);
        return input.substring(DELIMITER_START, delimiterEnd);
    }

    private void setContentStartIndex(int delimiterEnd) {
        contentStartIndex = delimiterEnd + 2;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getContentStartIndex() {
        return contentStartIndex;
    }
}
