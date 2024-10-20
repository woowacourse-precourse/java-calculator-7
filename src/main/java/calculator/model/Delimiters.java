package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
    }

    public boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
