package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INIT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getInput() {
        System.out.println(INIT_MESSAGE);
        return Console.readLine();
    }
}
