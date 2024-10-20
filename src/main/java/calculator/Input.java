package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ADD_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String readString() {
        System.out.println(ADD_MESSAGE);
        return Console.readLine();
    }
}
