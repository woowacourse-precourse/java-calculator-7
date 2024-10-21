package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";

    public void RequestInputString() {
        System.out.println(REQUEST_INPUT_STRING);
    }

    public String inputString() {
        return Console.readLine();
    }
}
