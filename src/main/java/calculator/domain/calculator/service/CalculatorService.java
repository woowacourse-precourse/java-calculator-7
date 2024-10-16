package calculator.domain.calculator.service;

import java.math.BigInteger;

import static calculator.domain.input.utils.InputValidateUtils.hasText;

public class CalculatorService {

    public BigInteger sum(String input) {
        if (!hasText(input)) {
            return BigInteger.ZERO;
        }

        throw new UnsupportedOperationException();
    }
}
