package calculator.Model;

import java.util.Arrays;

public class AdditionCalculator {
    public long add(long[] operands) {
        return Arrays.stream(operands).sum();
    }
}
