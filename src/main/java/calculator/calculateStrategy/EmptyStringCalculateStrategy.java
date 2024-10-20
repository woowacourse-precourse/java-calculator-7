package calculator.calculateStrategy;

import java.util.List;

public class EmptyStringCalculateStrategy implements CalculateStrategy {
    public EmptyStringCalculateStrategy() {
    }

    @Override
    public Integer add(List<Integer> operands) {
        return 0;
    }
}