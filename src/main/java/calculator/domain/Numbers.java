package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public Integer totalSum() {
        return numbers.stream()
            .reduce(0, Integer::sum);
    }
}
