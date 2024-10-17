package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String getInput() {
        return Console.readLine();
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}