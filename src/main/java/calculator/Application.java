package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final CalculatorController calculatorController = new CalculatorController(inputView, outputView);

        calculatorController.start();
    }
}
