package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        new CalculatorController(inputView, outputView).run();
    }
}
