package calculator;

import calculator.controller.CalculatorController;
import calculator.view.input.parser.DelimiterParserManager;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new DelimiterParserManager());
        calculatorController.run();
    }
}
