package calculator.part;

import java.math.BigInteger;
import java.util.Arrays;

public class CalculatorAdder {

    public BigInteger calculateAdd(BigInteger[] arrays){

        if(isAllPositive(arrays))
            return getSum(arrays);

        throw new IllegalArgumentException("양수만 입력가능합니다.");
    }

    private static boolean isAllPositive(BigInteger[] arrays) {
        return Arrays.stream(arrays)
                .allMatch(num -> num.compareTo(BigInteger.ZERO) == 1);
    }

    private static BigInteger getSum(BigInteger[] arrays) {
        return Arrays.stream(arrays)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

}
