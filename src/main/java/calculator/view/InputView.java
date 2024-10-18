package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String readNumber() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
