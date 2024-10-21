package calculator.service.impl;

import calculator.service.CalculatorService;
import java.math.BigInteger;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigInteger calculate(BigInteger[] numbers) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num : numbers) {
            sum = sum.add(num);
        }
        return sum;
    }
}