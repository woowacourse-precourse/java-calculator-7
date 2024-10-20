package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final List<String> DEFAULT_DELIMITERS = List.of(
            DelimiterConstant.VALIDATOR_COMMA.getValue(),
            DelimiterConstant.VALIDATOR_COLON.getValue());
    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
    }

    public void addCustomDelimiter(final String input) {
        int prefixLength = DelimiterConstant.CUSTOM_VALIDATOR_PREFIX.getValue().length();
        String customDelimiter = input.substring(prefixLength, prefixLength + 1);
        add(customDelimiter);
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