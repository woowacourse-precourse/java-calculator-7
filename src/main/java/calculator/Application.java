package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.inputString();

        CalculatorController calculatorController = new CalculatorController();
        Integer total = calculatorController.getNumberTotal(input);

        OutputView.OutputResult(total);
    }
}
