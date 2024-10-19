package calculator.domain.constant;

import java.util.Arrays;
import java.util.List;

public enum DefaultDelimiter {
    COMMA(","), COLON(":");

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static List<String> getDefaultDelimiters() {
        return Arrays.asList(COMMA.getDelimiter(), COLON.getDelimiter());
    }
}
