package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        CalculatorController calculatorController = new CalculatorController(
            inputView,
            outputView,
            calculator
        );
        calculatorController.run();
    }
}
