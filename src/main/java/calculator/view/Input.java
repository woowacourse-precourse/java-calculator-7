package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String READ_INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public String readInput() {
        System.out.println(READ_INPUT_MESSAGE);
        return Console.readLine();
    }
}
