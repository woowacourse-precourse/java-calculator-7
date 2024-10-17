package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private static final String USER_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public StringCalculator() {
    }

    public void run() {
        System.out.println(USER_INPUT_PROMPT);
        String stringToBeAdded = Console.readLine();
        // todo: 입력값검사, 숫자 추출, 숫자 변환, 숫자 더하기
        String result = stringToBeAdded;
        System.out.println(result);
    }
}
