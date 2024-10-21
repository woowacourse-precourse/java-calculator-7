package calculator.model;

import java.util.List;

public class Calculator {

    private Calculator() {}

    public static int calculate(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
