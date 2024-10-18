package calculator.parser.util;

import static calculator.exception.IllegalArgumentExceptionEnum.EMPTY_TOKEN;
import static calculator.exception.IllegalArgumentExceptionEnum.INVALID_CHARACTER;
import static calculator.exception.IllegalArgumentExceptionEnum.OUT_OF_RANGE;

import calculator.exception.ExceptionUtils;
import java.math.BigInteger;
import java.util.ArrayList;

public class TokensToIntConverter {

    public ArrayList<Integer> convertToInt(ArrayList<String> inputTokens) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : inputTokens) {
            if (token.matches(".*[^\\d].*")) {
                ExceptionUtils.throwIllegalArgException(INVALID_CHARACTER);
            }

            if (token.isEmpty()) {
                ExceptionUtils.throwIllegalArgException(EMPTY_TOKEN);
            }

            BigInteger bigInt = new BigInteger(token);
            if (bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0
                    || bigInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                ExceptionUtils.throwIllegalArgException(OUT_OF_RANGE);
            }

            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

}
