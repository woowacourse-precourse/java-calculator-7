package calculator;

import java.util.List;

public class ListCalculator {

    public long calculate(List<Long> input) {
        return input.stream().reduce(0L, Long::sum);
    }
}
