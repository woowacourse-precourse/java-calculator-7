package calculator.domain;

import java.math.BigInteger;

public class SumCalculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    /**
     * 숫자 문자열을 커스텀 구분자와 기본 구분자로 분리한 후, 각 숫자를 더하여 반환하는 메서드. 숫자 문자열이 비어 있으면 0을 반환.
     *
     * @param numberString    숫자 문자열
     * @param customSeparator 커스텀 구분자
     * @return 숫자의 합
     */
    public BigInteger Sum(String numberString, String customSeparator) {
        if (numberString == null || numberString.isEmpty()) {
            return BigInteger.ZERO;
        }

        String[] numbers = numberString.split("[" + DEFAULT_SEPARATORS + customSeparator + "]");

        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }

        return sum;
    }
}
