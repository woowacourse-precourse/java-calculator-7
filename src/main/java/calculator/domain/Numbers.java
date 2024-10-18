package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> elements = new ArrayList<>();

    public Numbers(List<String> elements) {
        elements.stream()
                .map(Number::new)
                .forEach(this.elements::add);
    }

    public int sum() {
        return elements.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
