package calculator.tokenizer;

import java.util.ArrayList;
import java.util.List;

public final class Delimiters {

    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
    }

    public void addDelimiter(String delimiter) {
        validateDelimiter(delimiter);
        delimiters.add(delimiter);
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter == null || delimiter.isEmpty() || isInteger(delimiter)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInteger(String delimiter) {
        try {
            Integer.parseInt(delimiter);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<String> getDelimiters() {
        return List.copyOf(delimiters);
    }

    public String concatenate() {
        StringBuilder result = new StringBuilder();
        for (String delimiter : delimiters) {
            result.append(delimiter);
        }
        return result.toString();
    }
}
