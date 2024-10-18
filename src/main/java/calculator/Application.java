package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.StringHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new CalculatorController(new Calculator(), new InputView(), new OutputView(),
                new StringHandler()).runCalculator();
    }
}
