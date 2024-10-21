package calculator.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Delimiters {
    private final Set<String> delimiters = new HashSet<>();

    public Delimiters(String[] delimiters) {
        this.delimiters.addAll(Arrays.asList(delimiters));
    }

    public void addDelimiter(String delimiter) {
        checkDelimiter(delimiter);
        delimiters.add(delimiter);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String delimiter : delimiters) {
            builder.append(delimiter).append("|");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    private void checkDelimiter(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
