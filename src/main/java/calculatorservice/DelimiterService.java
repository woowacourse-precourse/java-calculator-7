package calculatorservice;

import static vaildation.InputValidation.CheckCustomDelimiter;
import static vaildation.InputValidation.CheckInput;

public class DelimiterService { // 코드 실행 제어 서비스 클래스
    public int DelimiterProcess(String input) {
        int sumResult;
        String[] Custom;
        String customDelimiter = "";

        try { // 정상 흐름
            Custom = CheckCustomDelimiter(input); // 커스텀 구분자 검사
            if (Custom != null) {
                customDelimiter = Custom[0];
                input = Custom[1];
            }
            customDelimiter = CheckInput(input, customDelimiter); // 입력 유효성
            sumResult = SumInput(input, customDelimiter); // 숫자의 합
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return sumResult;
    }

    //입력의 유효성이 증명되면 덧셈을 수행한다.
    public static int SumInput(String remainingInput, String customDelimiter) {
        if (remainingInput.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] sumToken = remainingInput.split(customDelimiter);

        for (String token : sumToken) {
            if (token.isEmpty()) {
                continue;  // 빈 문자열 건너뛰기
            }
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
