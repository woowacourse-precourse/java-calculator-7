package calculator.converter;

import java.math.BigInteger;

public class StringToBigIntegerConverter {

    public BigInteger convert(String number) {
        try {
            BigInteger result = new BigInteger(number);

            if (result.compareTo(BigInteger.ZERO) <= 0) {
                throw new IllegalArgumentException("입력 값이 양수가 아닙니다.");
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
