package calculator.calculator;

import java.util.List;

public class Calculator {
    public static int sum(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
