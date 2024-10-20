package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Delimiters {
    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');

    private final Set<Character> delimiters;

    private Delimiters() {
        this.delimiters = new HashSet<>(DEFAULT_DELIMITERS);
    }

    private Delimiters(final Character delimiter) {
        this.delimiters = new HashSet<>(DEFAULT_DELIMITERS);
        this.delimiters.add(delimiter);
    }

    public static Delimiters createDelimiters() {
        return new Delimiters();
    }

    public static Delimiters createDelimiters(final Character delimiter) {
        return new Delimiters(delimiter);
    }

    public String getRegex() {
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[");

        for (Character delimiter : delimiters) {
            regexBuilder.append(delimiter);
            if (delimiter == '\\') {
                regexBuilder.append('\\');
            }
        }

        regexBuilder.append("]");
        return regexBuilder.toString();
    }
}
