package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readExpression() {
        return readLine(INPUT_MESSAGE);
    }

    protected String readLine(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
