package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.service.ParsingService;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();
        ParsingService parsingService = new ParsingService();
        CalculatorController calculatorController = new CalculatorController(calculatorService, parsingService);
        calculatorController.calculate(calculator);
    }
}
