package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DefaultDelimiter {
    COLON(":"),
    COMMA(",");

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static List<String> getDefaultDelimiters() {
        return Arrays.stream(DefaultDelimiter.values()).map(DefaultDelimiter::getDelimiter)
                .collect(Collectors.toList());
    }
}
