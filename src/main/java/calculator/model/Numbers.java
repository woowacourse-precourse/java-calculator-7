package calculator.model;

import java.util.List;

public class Numbers {
    private final List<Integer> values;

    public Numbers(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }
}
