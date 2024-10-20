package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String getInput() {
        printInputMessage();
        return Console.readLine();
    }

    private static void printInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
