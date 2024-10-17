package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_EXPRESSION_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputAdditionString() {
        System.out.println(INPUT_EXPRESSION_MESSAGE);
        return Console.readLine();
    }
}
