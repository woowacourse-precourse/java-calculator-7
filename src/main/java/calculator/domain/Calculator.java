package calculator.domain;

import java.math.BigInteger;
import java.util.List;

public class Calculator {

    public BigInteger sum(List<BigInteger> numbers) {
        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

}
