package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String WELCOME_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static void welcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static String getInput() {
        return Console.readLine();
    }
}
