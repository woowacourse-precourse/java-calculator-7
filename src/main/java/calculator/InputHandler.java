package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getInput() {
        return Console.readLine();
    }

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
