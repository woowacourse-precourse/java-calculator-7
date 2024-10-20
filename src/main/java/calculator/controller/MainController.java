package calculator.controller;

import calculator.domain.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;

//덧셈할 문자열을 입력해 주세요.
//1,2:3
//결과 : 6
public class MainController {

    private static final String REGEX = "[,;]";

    private MainController() {
    }

    public static MainController create() {
        return new MainController();
    }

    public void run() {
        final String input = InputView.startInput();
        final String[] stringNumber = splitString(input);

        Expression expression = new Expression(stringNumber);

        OutputView.printResultMessage(expression.getResult());
    }

    private String[] splitString(final String input) {
        return input.trim().split(REGEX);
    }
}
