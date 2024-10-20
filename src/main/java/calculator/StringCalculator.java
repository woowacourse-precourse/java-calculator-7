package calculator;

import java.math.BigInteger;
import java.util.List;

public final class StringCalculator {
    private StringCalculator(){

    }

    public static BigInteger calculate(List<String> stringNumberList){
        long sumOfLongValues = 0L;
        BigInteger sumOfBigIntegerValues = BigInteger.ZERO;

        for (String stringNumber : stringNumberList) {
            try {
                long longValue = Long.parseLong(stringNumber);
                sumOfLongValues += longValue;
            } catch (NumberFormatException e) {
                BigInteger bigIntegerValue = new BigInteger(stringNumber);
                sumOfBigIntegerValues = sumOfBigIntegerValues.add(bigIntegerValue);
            }
        }

        return sumOfBigIntegerValues.add(BigInteger.valueOf(sumOfLongValues));
    }
}
