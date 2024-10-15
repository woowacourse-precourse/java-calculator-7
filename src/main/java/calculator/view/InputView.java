package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String inputPrefix = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(inputPrefix);
        final String input = Console.readLine();
        return input;
    }
}
