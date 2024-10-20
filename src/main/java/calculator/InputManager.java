package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputStr() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
