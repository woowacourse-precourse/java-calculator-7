package calculator;

import java.math.BigInteger;
import java.util.List;

/**
 * 숫자 문자열들을 덧셈하여 결과를 출력하는 유틸리티 클래스입니다.
 * long 범위를 벗어나는 큰 수도 계산이 가능합니다.
 */
public final class StringCalculator {
    // 유틸리티 클래스의 인스턴스 생성방지
    private StringCalculator(){

    }

    /**
     * 문자열을 입력받아서 모두 더하여 반환하는 함수입니다. BigInteger만으로의 계산은
     * 메모리 낭비가 심하기 때문에 long으로 연산 가능한 수 들은 long으로 계산하여
     * BigInteger 숫자들의 합과 더해줍니다. 잘못된 입력값을 받으면
     * {@code IllegalArgumentException}이 발생합니다.
     * @param input 커스텀 구분자를 포함할 수 있는 문자열을 입력받습니다. null을 입력하면
     *              {@code NullPointerException}이 발생합니다.
     * @return  입력받은 숫자 문자열들을 모두 더한 문자열을 반환합니다.
     */
    public static BigInteger calculate(String input){
        List<String> numbers = NumberString.parse(input);

        long sumOfLongValues = 0L;
        BigInteger sumOfBigIntegerValues = BigInteger.ZERO;

        for (String number : numbers) {
            // long으로 변환이 가능한 지 체크 후 불가능하다면 BigInteger로 변환
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
