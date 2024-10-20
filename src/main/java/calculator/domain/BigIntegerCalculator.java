package calculator.domain;

import java.math.BigInteger;

public class BigIntegerCalculator {
    private BigInteger sum;

    public BigIntegerCalculator() {
        this.sum = BigInteger.ZERO;
    }

    public void add(String num) {
        BigInteger n = new BigInteger(num);

        validateNum(n);

        this.sum = sum.add(n);
    }

    private void validateNum(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }


    public String getResult() {
        return sum.toString();
    }
}
