package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.util.DelimiterParser;
import calculator.util.NumberParser;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new StringCalculator(
                        new DelimiterParser(),
                        new NumberParser()
                ),
                new InputView(),
                new ResultView()
        );

        calculatorController.run();
    }
}
