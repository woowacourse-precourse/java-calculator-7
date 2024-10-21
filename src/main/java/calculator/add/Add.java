package calculator.add;

import java.math.BigInteger;
import java.util.Set;
import static calculator.isDigit.IsDigit.isValid;

public class Add {
    // 숫자의 합을 계산하는 함수
    public static BigInteger processNumber(String input, Set<String> separatorSet) {
        if (input.isEmpty()) return BigInteger.ZERO; // 빈 입력은 합이 0
        BigInteger sum = BigInteger.ZERO;
        String regex = String.join("|", separatorSet); // 정규 표현식 or를 위해 "|"로 구분자 붙이기
        String[] tokens = input.split(regex); // 구분자 중 하나라도 보이면 분리

        for (String token : tokens) {
            if (!token.isEmpty()) { // 비어있지 않다면
                if (isValid(token)) { // 구분자로 분리한 뭉치 안에 숫자가 아닌 문자가 없다면
                    sum = sum.add(BigInteger.valueOf(Integer.parseInt(token))); // 합산
                }
            }
        }
        return sum;
    }
}
