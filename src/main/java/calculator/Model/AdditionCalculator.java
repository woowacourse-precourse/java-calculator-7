package calculator.Model;

import java.util.Arrays;

public class AdditionCalculator {
    public int add(int[] operands) {
        return Arrays.stream(operands).sum();
    }
}
