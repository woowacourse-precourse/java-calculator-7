package calculator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiters {
    private final Set<String> delimiters;

    public static Delimiters createWithCustomDelimiter(String customDelimiter) {
        return new Delimiters(customDelimiter);
    }

    public static Delimiters create() {
        return new Delimiters();
    }

    private Delimiters() {
        List<String> extendedDelimiters = new ArrayList<>();
        for (Delimiter delimiter : Delimiter.values()) {
            extendedDelimiters.add(delimiter.getSymbol());
        }
        this.delimiters = new HashSet<>(extendedDelimiters);
    }

    private Delimiters(String customDelimiter) {
        List<String> extendedDelimiters = new ArrayList<>();
        for (Delimiter delimiter : Delimiter.values()) {
            extendedDelimiters.add(delimiter.getSymbol());
        }
        extendedDelimiters.add(customDelimiter);
        this.delimiters = new HashSet<>(extendedDelimiters);
    }

    public List<String> getAllDelimiters() {
        return delimiters.stream().toList();
    }

}
