package calculator;

import java.math.BigInteger;

public class Calculator {

    private static final BigInteger MAX_LIMIT = BigInteger.valueOf(Integer.MAX_VALUE);

    // 각 토큰을 합산하고 예외 처리
    public int calculateSum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            try {
                BigInteger number = new BigInteger(token.trim());

                if (number.compareTo(BigInteger.ZERO) < 0) {
                    throw new IllegalArgumentException("음수 값이 포함되어 있습니다. : " + token);
                }

                // 범위를 벗어난 경우 예외 발생
                if (number.compareTo(MAX_LIMIT) > 0) {
                    throw new IllegalArgumentException("숫자가 범위를 초과했습니다. : " + token);
                }

                sum += number.intValue();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 문자열에 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }

        return sum;
    }
}
