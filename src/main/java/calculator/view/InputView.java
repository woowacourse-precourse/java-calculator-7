package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readString() {
        System.out.println(INPUT_MESSAGE);
        String InputString = Console.readLine();
        return InputString;
    }
}
