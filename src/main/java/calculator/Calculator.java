package calculator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculator {
    public static BigInteger adder(ArrayList<BigInteger> tokens){
        return tokens.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }
}
