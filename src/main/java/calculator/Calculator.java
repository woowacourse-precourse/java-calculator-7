package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String ENTER_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public static void start() {
        System.out.println(ENTER_MESSAGE);
        String userInput = Console.readLine();
    }

}
