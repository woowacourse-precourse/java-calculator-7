package calculator.domain;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Calculator {

    public BigInteger sumInteger(final Numbers<Integer> numbers) {
        final int size = numbers.getSize();
        return IntStream.range(0, size)
                .mapToObj(idx -> BigInteger.valueOf(numbers.getNumber(idx)))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

}
