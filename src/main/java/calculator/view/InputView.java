package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PREFIX = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(INPUT_PREFIX);
        final String input = Console.readLine();
        return input;
    }
}
