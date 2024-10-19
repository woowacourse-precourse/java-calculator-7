package calculator;

import static calculator.InputValidation.*;
import exception.CustomDelimiterException;
import java.util.StringTokenizer;

public class DelimiterService { // 연결을 위한 중간 흐름
    public int sendMessage(String input) {
        int sumResult = 0;
        String[] Custom;
        String customDelimiter = "";

        try { // 정상 흐름
            Custom = checkCustomDelimiter(input); // 커스텀 구분자
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
    public static int sumInput(String remainingInput, String customDelimiter) {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(remainingInput, customDelimiter);

        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken().strip());
        }
        return sum;
    }
}
