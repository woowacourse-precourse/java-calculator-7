package calculator;

import calculator.controller.Controller;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.run();
    }
}
