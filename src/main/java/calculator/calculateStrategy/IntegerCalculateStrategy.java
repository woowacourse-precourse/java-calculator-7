package calculator.calculateStrategy;

import java.util.List;

public class IntegerCalculateStrategy implements CalculateStrategy {
    public IntegerCalculateStrategy() {
    }

    @Override
    public Integer add(List<Integer> operands) throws IllegalArgumentException {
        Integer addResult = 0;
        for (Integer operand : operands) {
            if (!isOverflow(addResult, operand)) {
                addResult += operand;
            } else {
                throw new IllegalArgumentException("숫자의 합이 Integer 범위를 넘어간다");
            }
        }
        return addResult;
    }

    private boolean isOverflow(Integer addResult, Integer operand) {
        return addResult > 0 && operand > 0 && addResult > Integer.MAX_VALUE - operand;
    }
}