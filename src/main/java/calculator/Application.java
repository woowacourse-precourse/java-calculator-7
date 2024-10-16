package calculator;

import calculator.delimiter.CustomDelimiterManager;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new InputView(),
                new OutputView(),
                new CustomDelimiterManager());
        calculatorController.calculate();
    }
}
