package calculator;

import calculator.controller.StringAdderController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringAdderController controller = new StringAdderController(inputView, outputView);
        controller.run();
    }

}
