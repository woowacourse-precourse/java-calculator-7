package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String startMessage = "덧셈할 문자열을 입력해 주세요.";

    public static void printStartMessage() {
        System.out.println(startMessage);
    }

    public static String readInputString() {
        String input = readLine();
        return input;
    }
}
