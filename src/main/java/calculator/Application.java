package calculator;

import calculator.view.InputView;
import calculator.view.ConsoleInputView;
import calculator.view.OutputView;
import calculator.view.StandardOutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new StandardOutputView();
    }
}
