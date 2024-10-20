package calculator.calculateStrategy;

import java.util.List;

public class IntegerCalculateStrategy implements CalculateStrategy {
    public IntegerCalculateStrategy() {
    }

    @Override
    public Integer add(List<Integer> operands) {
        Integer addResult = 0;
        for (Integer operand : operands) {
            addResult += operand;
        }
        return addResult;
    }
}