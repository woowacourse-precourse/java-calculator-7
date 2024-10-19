package calculator;

import controller.Controller;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(calculator, inputView, outputView);

        controller.processUserInput();
    }
}
