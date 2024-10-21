package calculator.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public record Parser() {

    public BigDecimal parseToBigDecimal(String number) {
        BigDecimal result = handleEmptyString(number);
        return new BigDecimal(String.valueOf(result));
    }

    private static BigDecimal handleEmptyString(String number) {
        if (number.isEmpty()) {
            return new BigDecimal(BigInteger.ZERO);
        }
        return new BigDecimal(number);
    }
}
