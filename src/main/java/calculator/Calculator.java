package calculator;

import java.math.BigInteger;
import java.util.List;

public class Calculator {

    public static BigInteger add(List<BigInteger> numbers) {
        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}