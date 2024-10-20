package calculator;

import java.util.HashSet;
import java.util.Set;

public class Delimiters {

    private final String COMMA = ",";
    private final String COLON = ":";

    private final Set<String> delimiters = new HashSet<>();

    public Delimiters() {
        delimiters.add(COMMA);
        delimiters.add(COLON);
    }

    public void add(String newDelimiter) {
        delimiters.add(newDelimiter);
    }

    public boolean isDelimiter(String element) {
        return delimiters.contains(element);
    }
}
