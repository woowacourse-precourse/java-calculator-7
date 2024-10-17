package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private final String input;
    private final Set<String> delimiters;

    public DelimiterParser(final String input) {
        this.input = input;
        this.delimiters = new HashSet<>();
        parseDelimiters();
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String getInput() {
        return input;
    }

    private void parseDelimiters() {
        defaultDelimiters();
    }

    private void defaultDelimiters() {
        delimiters.addAll(Arrays.asList(DEFAULT_DELIMITERS));
    }
}
