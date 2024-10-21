package calculator.model;

import java.math.BigInteger;

public class Operand {
    private final BigInteger[] numbers;

    private Operand(String delimiter, String expression) {
        if (expression.isEmpty()) {
            this.numbers = new BigInteger[] { BigInteger.ZERO };
            return;
        }

        String[] numbers = expression.split(delimiter);
        this.numbers = new BigInteger[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i] = new BigInteger(numbers[i]);
        }
    }

    public static Operand create(String delimiter, String expression) {
        return new Operand(delimiter, expression);
    }

    public BigInteger[] getNumbers() {
        return numbers;
    }
}
