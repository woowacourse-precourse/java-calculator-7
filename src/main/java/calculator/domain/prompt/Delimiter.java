package calculator.domain.prompt;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    private static final char DEFAULT_DELIMITER_COMMA = ',';
    private static final char DEFAULT_DELIMITER_COLON = ':';
    private static final int MAX_DELIMITER_COUNT = 3;

    private final Set<Character> delimiters;

    public Delimiter() {
        this.delimiters = new HashSet<>(Set.of(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));
    }

    public void add(char delimiter) {
        if (this.delimiters.size() >= MAX_DELIMITER_COUNT) {
            throw new IllegalArgumentException();
        }

        this.delimiters.add(delimiter);
    }

    public boolean isIn(char delimiter) {
        return this.delimiters.contains(delimiter);
    }

}
