package calculator.input;

import java.util.ArrayList;

public class CustomInput {
    public static int customParseSum(String input) {
        // 구분자를 찾기 위해 문자열 \n으로 나누는 과정이 필요
        // \n을 기준으로 구분자와 숫자로 이루어진 문자열. 두 파트로 나누어 줄 것임.
        String[] parts = input.split("\\\\n", 2);

        // 첫 파트는 구분자 설정. 맨 앞에 있는 //를 자르면 구분자만 남는다.
        String delimiterPart = parts[0].substring(2).trim();

        // 구분자가 없는 경우 예외 처리
        if (delimiterPart.isEmpty()) {
            throw new IllegalArgumentException("구분자가 공백입니다.");
        }

        // 두 번째 파트는 숫자로 이루어진 문자열.
        String numberPart = parts[1];

        // 구분자로 숫자 나누기
        String[] tokens = numberPart.split(delimiterPart);
        int result = 0;

        for (String token : tokens) {
            // 토큰이 숫자인지 확인
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다");
            }
            int tokenToInt = Integer.parseInt(token);

            // 숫자가 양수가 아닌 경우 예외 발생
            if (tokenToInt <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다");
            }
            // 양수일 경우에는 숫자 합산
            result += tokenToInt;
        }
        return result;
    }
}
