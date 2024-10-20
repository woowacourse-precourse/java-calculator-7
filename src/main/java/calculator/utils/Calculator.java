package calculator.utils;

import java.util.List;

public class Calculator {
    public int calculateResult(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
