package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputService {
    private final String inputComment = "덧셈할 문자열을 입력해 주세요.";

    public String fetchUserInput() {
        System.out.println(inputComment);

        return Console.readLine();
    }

    public void printResult(Double result) {
        if (Math.floor(result) == result) {
            System.out.println("결과 : " + result.intValue());
            return;
        }

        System.out.println("결과 : " + result);
    }
}
