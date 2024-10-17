package calculator;

import calculator.separator.CustomSeparatorManager;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new InputView(),
                new OutputView(),
                new CustomSeparatorManager());
        calculatorController.calculate();
    }
}
