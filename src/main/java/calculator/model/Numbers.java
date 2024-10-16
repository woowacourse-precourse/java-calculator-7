package calculator.model;

import java.util.List;

public class Numbers {
    private final List<Integer> values;

    public Numbers(List<Integer> numerics) {
        this.values = numerics;
    }

    public List<Integer> getValues() {
        return values;
    }
}
