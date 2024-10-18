package calculator.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum DefaultDelimiter {

    COMMA(","),
    COLON(":");

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static Set<String> getAll() {
        return Arrays.stream(DefaultDelimiter.values())
                .map(DefaultDelimiter::getDelimiter)
                .collect(Collectors.toSet());
    }
}
