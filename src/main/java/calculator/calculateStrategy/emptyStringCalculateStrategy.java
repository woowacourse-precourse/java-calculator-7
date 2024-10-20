package calculator.calculateStrategy;

import java.util.List;

public class emptyStringCalculateStrategy implements CalculateStrategy {
    public emptyStringCalculateStrategy() {
    }

    @Override
    public Integer add(List<Integer> operands) {
        return null;
    }
}