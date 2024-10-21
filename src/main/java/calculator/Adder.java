package calculator;

import java.math.BigInteger;
import java.util.List;

public class Adder {
    private final List<BigInteger> numList;

    public Adder(List<BigInteger> numList) {
        this.numList = numList;
    }

    // 추출된 모든 숫자를 합산하여 반환
    public BigInteger addAll() {
        BigInteger sum = new BigInteger("0");
        for(BigInteger number : numList) {
            sum = sum.add(number);
        }

        return sum;
    }
}
