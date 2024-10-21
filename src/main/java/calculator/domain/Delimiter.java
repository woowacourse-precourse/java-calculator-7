package calculator.domain;

import java.util.Arrays;
import java.util.List;

public enum Delimiter {
    COMMA(","),
    COLON(":");
    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static List<String> getAll() {
        return Arrays.stream(Delimiter.values())
                .map(Delimiter::getDelimiter)
                .toList();
    }
}
