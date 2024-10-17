package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String additionInputMessage = "덧셈할 문자열을 입력해 주세요.";

    public String input() {
        System.out.println(additionInputMessage);
        return Console.readLine();
    }
}
