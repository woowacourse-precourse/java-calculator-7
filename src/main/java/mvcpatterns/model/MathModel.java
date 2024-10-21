package mvcpatterns.model;

import java.math.BigInteger;

public class MathModel {

    public BigInteger sum(BigInteger... numbers) {
        BigInteger sum = new BigInteger("0");

        for (BigInteger n : numbers) {
            sum = sum.add(n);
        }

        return sum;
    }
}
