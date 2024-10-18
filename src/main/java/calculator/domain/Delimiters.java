package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private final List<String> elements;

    public Delimiters() {
        this.elements = new ArrayList<>();
        elements.add(",");
        elements.add(":");
    }

    public List<String> getElements() {
        return new ArrayList<>(elements);
    }

    public void addDelimiter(String delimiter) {
        elements.add(delimiter);
    }
}
