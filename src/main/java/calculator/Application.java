package calculator;

import calculator.controller.CalculatorController;
import calculator.parser.DefaultStringParser;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final CalculatorController calculatorController = new CalculatorController(
                new OutputView(),
                new InputView(
                        new InputValidator()
                ),
                new StringAdditionCalculator(
                        new DefaultStringParser()
                )
        );
        
        calculatorController.run();
    }
}
