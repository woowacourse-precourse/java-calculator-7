package calculator;

import java.math.BigInteger;
import java.util.List;

public final class StringCalculator {
    private StringCalculator(){

    }

    public static BigInteger calculate(List<String> numberString){
        long sumOfLongValues = 0L;
        BigInteger sumOfBigIntegerValues = BigInteger.ZERO;

        for (String number : numberString) {
            try {
                long longValue = Long.parseLong(number);
                sumOfLongValues += longValue;
            } catch (NumberFormatException e) {
                BigInteger bigIntegerValue = new BigInteger(number);
                sumOfBigIntegerValues = sumOfBigIntegerValues.add(bigIntegerValue);
            }
        }

        return sumOfBigIntegerValues.add(BigInteger.valueOf(sumOfLongValues));
    }
}
