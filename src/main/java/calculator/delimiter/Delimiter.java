package calculator.delimiter;

import java.util.*;

public abstract class Delimiter {

    private static Delimiter instance;

    protected Set<String> delimiters;

    public Delimiter() {
        delimiters = new HashSet<>();
        delimiters.add(":");
        delimiters.add(",");
    }

    public static Delimiter getInstance() {
        instance = new CustomDelimiter();
        return instance;
    }

    public static void setInstance(Delimiter delimiter) {
        instance = delimiter;
    }

    public List<String> divideCharacter(String s) {
        List<String> result = new ArrayList<>();

        if (!hasCustomDelimiter(s) && hasDelimiter(s)) {
            result = Arrays.stream(s.split("[:,]")).toList();
        }

        return result;
    }

    public boolean containsDelimiter(String s) {
        return delimiters.stream().anyMatch(s::contains);
    }

    public boolean hasDelimiter(String s) {
        return s.contains(":") || s.contains(",");
    }

    public boolean isDigit(String s) {
        return s.matches("\\d+");
    }

    public abstract boolean hasCustomDelimiter(String s);

    protected abstract void addDelimiter(String delimiter);

}
