package calculatorservice;

import static vaildation.InputValidation.*;
import exception.CustomDelimiterException;

public class DelimiterService { // 코드 실행 제어 서비스 클래스
    public long sendMessage(String input) {
        long sumResult = 0;
        String[] Custom;
        String customDelimiter = "";

        try { // 정상 흐름
            Custom = checkCustomDelimiter(input); // 커스텀 구분자 검사
            if (Custom != null) {
                customDelimiter = Custom[0];
                input = Custom[1];
            }
            customDelimiter = CheckInput(input, customDelimiter); // 입력 유효성
            sumResult = sumInput(input, customDelimiter); // 숫자의 합
        } catch (CustomDelimiterException e) {
            System.out.println("[커스텀 문자 지정 오류] 메시지: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[입력 오류] 메시지: " + e.getMessage());
        }

        return sumResult;
    }

    //입력의 유효성이 증명되면 덧셈을 수행한다.
    public static long sumInput(String remainingInput, String customDelimiter) {
        long sum = 0;
        String[] sumToken = remainingInput.split(customDelimiter);

        for (String token : sumToken) {
            sum += Long.parseLong(token);
        }

        return sum;
    }
}
