package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new InputView(), new OutputView(),
                new Calculator());
        calculatorController.run();
    }
}
