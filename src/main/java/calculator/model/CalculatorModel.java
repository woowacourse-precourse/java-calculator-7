package calculator.model;

import java.util.Arrays;

public class CalculatorModel {

    public int calculate(int[] operands) {
        return Arrays.stream(operands).sum();
    }
}
