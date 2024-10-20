package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public void run() {
        //1. 문자열 입력받기
        String str = getString();
    }

    private static String getString() {
        System.out.println(inputMessage);
        return Console.readLine();
    }
}
