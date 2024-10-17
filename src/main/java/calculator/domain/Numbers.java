package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void add(String numberStr) {
        numbers.add(new Number(numberStr));
    }

    public int size() {
        return numbers.size();
    }

    public long sum() {
        long sum = 0;
        for (Number number : numbers) {
            sum = number.add(sum);
        }
        return sum;
    }
}
