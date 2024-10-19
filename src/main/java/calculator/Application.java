package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final CalculatorController calculatorController = new CalculatorController(
                new OutputView(),
                new InputView()
        );

        calculatorController.run();
    }
}
