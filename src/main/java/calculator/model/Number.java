package calculator.model;

import java.math.BigInteger;

public record Number(
    BigInteger number
) {
    public static Number from(String number) {
        try {
            BigInteger bigInteger = new BigInteger(number);
            if (!isPositiveNumber(bigInteger)) {
                throw new IllegalArgumentException("값은 양수로 입력해주세요.");
            }
            return new Number(bigInteger);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("값은 양수로 입력해주세요.");
        }
    }

    private static boolean isPositiveNumber(BigInteger bigInteger) {
        return bigInteger.compareTo(BigInteger.ZERO) > 0;
    }
}
