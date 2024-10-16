package calculator.core.service;

import calculator.converter.StringToBigIntegerListConverter;

import java.math.BigInteger;

import static calculator.util.StringUtils.hasText;
import static java.math.BigInteger.ZERO;

public class CalculatorCoreService {

    public BigInteger sum(String input) {
        if (!hasText(input)) {
            return ZERO;
        }

        BigInteger sum = ZERO;

        for (BigInteger number : StringToBigIntegerListConverter.convert(input)) {
            sum = sum.add(number);
        }

        return sum;
    }
}
