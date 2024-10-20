package calculator;

import calculator.controller.StringAdderController;
import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        StringAdderController controller = new StringAdderController(inputView, outputView, calculator);
        controller.run();
    }

}
