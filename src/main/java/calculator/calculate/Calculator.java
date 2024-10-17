package calculator.calculate;

import java.util.List;

public class Calculator {

    public int multipleSum(List<Integer> positiveNumbers) {
        return positiveNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
