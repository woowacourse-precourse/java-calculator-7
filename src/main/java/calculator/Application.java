package calculator;

import calculator.controller.CalculateController;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculateController calculateController = new CalculateController(new OutputView(), new InputView(),
                new Parser());
        calculateController.start();

    }
}
