package calculator.delimiter;

import java.util.HashSet;
import java.util.Set;

public abstract class Delimiter {

    private static Delimiter instance = new CustomDelimiter();

    private Set<String> delimiters;

    public Delimiter() {
        delimiters = new HashSet<>();
        delimiters.add(":");
        delimiters.add(",");
    }

    public static Delimiter getInstance() {
        return instance;
    }

    public static void setInstance(Delimiter delimiter) {
        instance = delimiter;
    }

}
