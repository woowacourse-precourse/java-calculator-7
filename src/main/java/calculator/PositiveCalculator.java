package calculator;

import java.util.Arrays;

public class PositiveCalculator implements Calculator {

    @Override
    public int add(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
