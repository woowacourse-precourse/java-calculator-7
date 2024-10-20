package calculator.util.delimiter;

import java.util.Arrays;
import java.util.List;

public enum BasicDelimiter {

    COMMA(","),
    COLON(":");

    private final String delimiter;

    BasicDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static List<String> getDelimiters() {
        return Arrays.stream(BasicDelimiter.values())
                .map(BasicDelimiter::getDelimiter)
                .toList();
    }

}
