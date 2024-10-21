package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputReceiver {

    private InputReceiver() {}

    private static final String INPUT_MESSAGE = "덧셈할 문자를 입력해 주세요.";

    public static String readInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
