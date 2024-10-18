package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.util.InputParser;
import calculator.util.InputValidator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        InputValidator inputValidator = new InputValidator();
        Calculator calculator = new Calculator();
        CalculatorView calculatorView = new CalculatorView();

        CalculatorController calculatorController = new CalculatorController(calculator, inputParser, inputValidator,
                calculatorView);

        calculatorController.run();
    }
}
