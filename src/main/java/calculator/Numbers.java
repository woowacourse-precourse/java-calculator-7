package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] numberStrings) {
        numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(new Number(numberString));
        }
    }

    public BigInteger sum() {
        BigInteger sum = BigInteger.ZERO;
        for (Number number : numbers) {
            sum = sum.add(number.getValue());
        }
        return sum;
    }
}
