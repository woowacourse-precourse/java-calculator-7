package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_STRING_TO_ADD = "덧셈할 문자열을 입력해주세요.";

    public String getInputString() {
        System.out.println(INPUT_STRING_TO_ADD);
        return Console.readLine();
    }
}
