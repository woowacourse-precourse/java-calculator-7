package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.StringSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        StringSeparator stringSeparator = new StringSeparator(calculator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(calculator, stringSeparator, inputView,
                outputView);
        calculatorController.run();
    }
}
