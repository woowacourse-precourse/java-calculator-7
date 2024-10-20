package calculator.calculateStrategy;

import java.util.List;

public class emptyStringCalculate implements Calculate {
    public emptyStringCalculate() {
    }

    @Override
    public Integer add(List<Integer> operands) {
        return null;
    }
}