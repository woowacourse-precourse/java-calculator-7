package calculator.model;

import java.util.List;

public class SumCalculator {

    public int calculate(List<Integer> nums) {
        return nums.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
