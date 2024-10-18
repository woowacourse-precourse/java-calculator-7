package calculator.domain;

import java.util.Arrays;

public class PositiveCalculator implements Calculator {

    private static final int ZERO = 0;
    private final int[] positiveNums;

    public PositiveCalculator(int[] positiveNums) {
        validatePositive(positiveNums);
        this.positiveNums = positiveNums;
    }

    @Override
    public int sum() {
        if (positiveNums.length == ZERO) {
            return ZERO;
        }
        return Arrays.stream(positiveNums).sum();
    }

    private void validatePositive(int[] nums) {
        Arrays.stream(nums).forEach(num -> {
            if (num <= 0) {
                throw new IllegalArgumentException("모든 수는 양수여야한다. 잘못된 숫자: " + num);
            }
        });
    }
}