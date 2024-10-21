package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private final List<String> delimiters;

    public Delimiter() {
        delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
    }

    public void add(String delimiter) {
        delimiters.add(delimiter);
    }

    @Override
    public String toString() {
        return String.join("|", delimiters);
    }
}
