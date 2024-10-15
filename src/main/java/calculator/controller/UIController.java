package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class UIController {
    private static final String SUM_STRING_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String receive() {
        OutputView.print(SUM_STRING_INPUT_MESSAGE);
        return InputView.readValue();
    }
}
