package calculator.core;

import calculator.utils.NumUtil;
import calculator.input.Input;

public class Calculator {

    private final Input input;

    private Calculator(Input input) {
        this.input = input;
    }

    public static Calculator of(String consoleInput) {
        return new Calculator(Input.of(consoleInput));
    }

    public int sum() {
        int[] nums = NumUtil.toIntArray(input);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
