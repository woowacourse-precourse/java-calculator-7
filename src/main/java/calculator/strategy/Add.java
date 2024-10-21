package calculator.strategy;

import calculator.strategy.Calculate;

import java.util.List;

public class Add implements Calculate {
    @Override
    public int computeOperation(List<Integer> numbers) {
        int result = 0;
        for (Integer n : numbers) {
            result += n;
        }
        return result;
    }


}
