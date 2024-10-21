package calculator.model;

import java.math.BigDecimal;

public class SumCalculator {
    private BigDecimal parseToBigDecimal(String token) {
        try {
            return new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못되거나 허용되지 않은 형식입니다.");
        }
    }
}