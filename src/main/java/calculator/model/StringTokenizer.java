package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringTokenizer implements Tokenizer {
    private final StringBuilder delimiters;

    public StringTokenizer(StringBuilder delimiters) {
        this.delimiters = delimiters;
        addDelimiter(",");
        addDelimiter(":");
    }

    private void addDelimiter(String delimiter) {
        if (delimiters.isEmpty()) {
            delimiters.append(delimiter);
        } else {
            delimiters.append("|");
            delimiters.append(delimiter);
        }
    }

    @Override
    public List<String> tokenize(String input) {
        String string = input;

        if (customDelimiterContains(string)) {
            string = addCustomDelimiter(string);
        }

        return Arrays.stream(string.split(delimiters.toString())).toList();
    }

    private String addCustomDelimiter(String input) {
        String[] split = input.split("//|\\\\n");
        addDelimiter(split[1]);

        return split[2];
    }

    private boolean customDelimiterContains(String input) {
        return input.startsWith("//");
    }
}
