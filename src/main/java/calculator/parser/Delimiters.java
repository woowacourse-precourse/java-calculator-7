package calculator.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiters {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private final Set<String> delimiters;

    public Delimiters() {
        this.delimiters = new HashSet<>(List.of(COMMA, COLON));
    }

    public void add(String newDelimiter) {
        delimiters.add(newDelimiter);
    }

    public boolean isDelimiter(String element) {
        return delimiters.contains(element);
    }
}
