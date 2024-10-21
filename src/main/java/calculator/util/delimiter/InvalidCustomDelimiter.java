package calculator.util.delimiter;

import java.util.Arrays;
import java.util.List;

public enum InvalidCustomDelimiter {

    DOUBLE_SLASH("//"),
    NEWLINE("\\n"),
    BLANK(" "),
    NULL(""),
    NUMBER("[0-9]");

    private final String delimiter;

    InvalidCustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static List<String> getDelimiters() {
        return Arrays.stream(InvalidCustomDelimiter.values())
                .map(InvalidCustomDelimiter::getDelimiter)
                .toList();
    }

}
