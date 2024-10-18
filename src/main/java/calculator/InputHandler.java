package calculator;


import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
static String welcomeMessage = "덧셈할 문자열을 입력해 주세요.";

    public static void welcome() {
        System.out.println(welcomeMessage);
    }

    public String getInput() {
        return Console.readLine();
    }
}
