package calculator.tokenizer;

import java.util.ArrayList;
import java.util.List;

public final class Delimiters {

    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
    }

    public void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
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
