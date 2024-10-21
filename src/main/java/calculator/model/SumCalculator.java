package calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SumCalculator {

    public BigDecimal calculateSum(String input) {
        String[] tokens = splitNumbers(input);
        BigDecimal sumResult = BigDecimal.ZERO;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                BigDecimal number = parseToBigDecimal(token);
                sumResult = sumResult.add(number);
            }
        }

        return sumResult.setScale(0, RoundingMode.DOWN);
    }

    private BigDecimal parseToBigDecimal(String token) {
        try {
            return new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못되거나 허용되지 않은 형식입니다.");
        }
    }
}