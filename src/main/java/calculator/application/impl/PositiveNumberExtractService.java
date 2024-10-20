package calculator.application.impl;

import calculator.application.ExtractService;
import java.math.BigInteger;
import java.util.List;

public class PositiveNumberExtractService implements ExtractService {

    @Override
    public List<BigInteger> extractNumbers(List<String> data) {
        return data.stream()
                .map(this::parseNumber)
                .toList();
    }

    private BigInteger parseNumber(String data) {
        try {
            BigInteger number = new BigInteger(data);
            validatePositive(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }

}
