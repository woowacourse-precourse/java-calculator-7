package calculator.view;

import java.util.Arrays;
import java.util.stream.Collectors;

enum DefaultDelimiters {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    DefaultDelimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    String getDelimiter() {
        return delimiter;
    }

    static String joinAllDelimiters() {
        return Arrays.stream(DefaultDelimiters.values())
                .map(DefaultDelimiters::getDelimiter)
                .collect(Collectors.joining("|"));
    }
}
