package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private String input;


    public InputView() {
        System.out.println(INPUT_PROMPT);
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
