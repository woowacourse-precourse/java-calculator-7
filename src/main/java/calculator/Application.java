package calculator;

import controller.Controller;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(
                new Calculator(),
                new InputView(),
                new OutputView()
        );
        controller.processUserInput();
    }
}
