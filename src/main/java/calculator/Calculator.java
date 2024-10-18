package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String INPUT_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void run() {
        String input = inputString();
    }

    private String inputString() {
        System.out.println(INPUT_STRING_MESSAGE);
        return Console.readLine();
    }

}
