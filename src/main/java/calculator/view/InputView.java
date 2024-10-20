package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLEASE_INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";

    public String readUserInput() {
        System.out.println(PLEASE_INPUT_STRING);
        return Console.readLine();
    }
}