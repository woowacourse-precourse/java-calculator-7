package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String inputString() {
        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }
}
