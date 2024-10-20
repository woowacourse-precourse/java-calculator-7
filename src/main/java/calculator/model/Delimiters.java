package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
    }

    public void addCustomDelimiter(final String input) {
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(),
                CUSTOM_DELIMITER_PREFIX.length() + 1);
        add(customDelimiter);
    }

    public boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public String toConcatenatedString() {
        return delimiters.stream().reduce("", (a, b) -> a + b);
    }

    private void add(final String delimiter) {
        if (!delimiters.contains(delimiter)) {
            delimiters.add(delimiter);
        }
    }
}
