package calculator.domain;

import java.util.Set;

public class Delimiter {
    private final Set<Character> delimiter;

    public Delimiter(Set<Character> delimiter) {
        this.delimiter = delimiter;
    }

    public boolean contains(char c) {
        return delimiter.contains(c);
    }
}
