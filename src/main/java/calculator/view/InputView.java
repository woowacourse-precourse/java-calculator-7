package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String readNumber() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
