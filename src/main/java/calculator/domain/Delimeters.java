package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimeters {

    private final List<String> elements;

    public Delimeters() {
        this.elements = new ArrayList<>();
        elements.add(",");
        elements.add(":");
    }

    public List<String> getElements() {
        return new ArrayList<>(elements);
    }
}
