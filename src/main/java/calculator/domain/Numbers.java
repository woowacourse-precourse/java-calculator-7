package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> value;

    public Numbers() {
        this.value = new ArrayList<>();
    }

    public void add(int i) {
        this.value.add(i);
    }

    public int getSum() {
        return value.stream()
                .mapToInt(i -> i)
                .sum();
    }
}
