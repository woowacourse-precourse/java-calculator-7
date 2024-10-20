package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String USER_INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";

    public String getConsoleInput() {
        print(USER_INPUT_STRING);
        return Console.readLine();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
