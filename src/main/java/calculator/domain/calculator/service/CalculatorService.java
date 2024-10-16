package calculator.domain.calculator.service;

import calculator.domain.calculator.utils.CalculatorConverterUtils;

import java.math.BigInteger;

import static calculator.domain.input.utils.InputValidateUtils.hasText;
import static java.math.BigInteger.ZERO;

public class CalculatorService {

    public BigInteger sum(String input) {
        if (!hasText(input)) {
            return ZERO;
        }

        BigInteger sum = ZERO;

        for (BigInteger number : CalculatorConverterUtils.convert(input)) {
            sum = sum.add(number);
        }

        return sum;
    }
}
