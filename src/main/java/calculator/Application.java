package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterExtractor;
import calculator.domain.NumberStringExtractor;
import calculator.validator.CalculatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = getCalculatorController();
        calculatorController.start();
    }

    private static CalculatorController getCalculatorController() {
        return new CalculatorController(
                new InputView(),
                new OutputView(),
                new Calculator(
                        new CalculatorValidator(),
                        new NumberStringExtractor(
                                new CustomDelimiterExtractor()
                        )
                )
        );
    }
}
