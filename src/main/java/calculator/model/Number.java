package calculator.model;

import java.math.BigInteger;

public record Number(
    BigInteger number
) {
    public static Number from(String number) {
        try {
            BigInteger bigInteger = new BigInteger(number);
            return new Number(bigInteger);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("값은 숫자로 입력해주세요.");
        }
    }
}
