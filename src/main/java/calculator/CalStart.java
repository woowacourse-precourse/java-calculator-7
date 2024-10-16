package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalStart {
    private static final String START_CAL_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String InputMessage() {
        System.out.println(START_CAL_MESSAGE);
        return Console.readLine();
    }
}
