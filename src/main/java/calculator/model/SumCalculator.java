package calculator.model;

import java.util.List;

public class SumCalculator implements Calculator {

    public int calculate(List<Integer> nums) {
        return nums.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
