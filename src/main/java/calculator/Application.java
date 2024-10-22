package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.util.Parser;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();
        Parser parser = new Parser();
        CalculatorController calculatorController = new CalculatorController(calculatorService, parser);
        calculatorController.calculate(calculator);
    }
}
