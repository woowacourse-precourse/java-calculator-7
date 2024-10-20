package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiters {
    Set<Character> delimiters;

    public Delimiters(Set<Character> initDelimiters) {
        this.delimiters = new HashSet<>(initDelimiters);
    }

    public void addDelimiter(char delimiter) {
        delimiters.add(delimiter);
    }

    public Boolean isDelimiter(char delimiter) {
        return delimiters.contains(delimiter);
    }
}
