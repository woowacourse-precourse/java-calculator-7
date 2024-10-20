package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(List.of(",", ":"));
    }

    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    public void addDelimiter(String customDelimiter) {
        delimiters.add(customDelimiter);
    }
}
