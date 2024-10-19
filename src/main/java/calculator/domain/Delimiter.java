package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');
    private static final int CUSTOM_DELIMITER_COUNT_LIMIT = 1;

    private final Set<Character> customDelimiters;

    public Delimiter() {
        this.customDelimiters = new HashSet<>();
    }

    public void add(char delimiter) {
        if (this.customDelimiters.size() >= CUSTOM_DELIMITER_COUNT_LIMIT) {
            throw new IllegalArgumentException();
        }

        this.customDelimiters.add(delimiter);
    }

    public boolean isIn(char delimiter) {
        return this.customDelimiters.contains(delimiter) || DEFAULT_DELIMITERS.contains(delimiter);
    }

}
