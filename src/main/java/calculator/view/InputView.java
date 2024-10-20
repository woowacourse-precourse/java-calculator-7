package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";

    public String readInputExpression() {
        System.out.println(INPUT_STRING);
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            return "0";
        }
        return input;
    }
}
