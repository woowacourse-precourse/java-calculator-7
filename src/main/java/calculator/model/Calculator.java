package calculator.model;

import java.util.Arrays;

public class Calculator {

    public static Calculator getInstance() {
        return new Calculator();
    }

    public int add(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}
