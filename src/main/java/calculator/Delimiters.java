package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private final List<Character> delimiters = new ArrayList<>();

    public void addDelimiter(char delimiter) {
        delimiters.add(delimiter);
    }

    public List<Character> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    public boolean hasSingleDelimiter() {
        return delimiters.size() == 1;
    }
}
