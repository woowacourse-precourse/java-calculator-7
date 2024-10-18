package calculator.parser.util;

import calculator.exception.ExceptionUtils;
import calculator.exception.IllegalArgumentExceptionEnum;
import java.math.BigInteger;
import java.util.ArrayList;

public class TokensToIntConverter {

    public ArrayList<Integer> convertToInt(ArrayList<String> tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (token.matches(".*[^\\d].*")) {
                ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.INVALID_CHARACTER);
            }

            if (token.isEmpty()) {
                ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.EMPTY_TOKEN);
            }

            BigInteger bigIntValue = new BigInteger(token);
            if (bigIntValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                    bigIntValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.OUT_OF_RANGE);
            }

            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

}
