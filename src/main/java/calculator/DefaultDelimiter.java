package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DefaultDelimiter {
    COLON(":"),
    REST(",");

    private final String delimiter;

    private DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    private String getDelimiter() {
        return delimiter;
    }

    public static List<String> get() {
        return Arrays.stream(DefaultDelimiter.values())
                .map(DefaultDelimiter::getDelimiter)
                .collect(Collectors.toList());
    }
}
