package calculator;

import java.math.BigInteger;
import java.util.List;

public class Calculator {

    public static BigInteger add(List<BigInteger> numbers) {
        BigInteger result = BigInteger.ZERO;

        for (BigInteger number : numbers) {
            result = result.add(number);
        }
        return result;
    }
}