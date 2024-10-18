package calculator.domain;

import java.util.Arrays;

public class PositiveCalculator implements Calculator {

    private static final int ZERO = 0;

    @Override
    public int add(int[] nums) {
        if (nums.length == ZERO) {
            return ZERO;
        }
        return Arrays.stream(nums).sum();
    }
}
