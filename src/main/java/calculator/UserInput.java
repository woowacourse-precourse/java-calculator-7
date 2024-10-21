package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public static void showInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public static String receiveInput() {
        return Console.readLine();
    }
}
