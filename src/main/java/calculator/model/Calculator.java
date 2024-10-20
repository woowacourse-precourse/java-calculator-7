package calculator.model;

import java.util.List;

public class Calculator {
    private int sum;

    public Calculator() {
        this.sum = 0;
    }

    public int addAll(List<Integer> integers) {
        integers.forEach(num -> sum += num);
        return sum;
    }
}
