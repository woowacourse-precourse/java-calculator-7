package calculator.converter;

import java.math.BigInteger;

import static calculator.message.ErrorMessage.INVALID_BIG_INTEGER;
import static calculator.message.ErrorMessage.NOT_POSITVE_INTEGER;
import static java.math.BigInteger.ZERO;

public class StringToPositiveBigIntegerConverter {

    public BigInteger convert(String number) {
        try {
            BigInteger result = new BigInteger(number);

            if (result.compareTo(ZERO) <= 0) {
                throw new IllegalArgumentException(NOT_POSITVE_INTEGER.getMessage());
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BIG_INTEGER.getMessage());
        }
    }
}
