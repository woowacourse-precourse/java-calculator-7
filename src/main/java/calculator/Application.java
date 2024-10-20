package calculator;

import calculator.domain.controller.CalculatorController;
import calculator.domain.service.CalculatorService;
import calculator.domain.service.NormalCalculatorImpl;
import calculator.domain.service.SpecialCalculatorImpl;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService(new NormalCalculatorImpl(), new SpecialCalculatorImpl());
        CalculatorController controller = new CalculatorController(calculatorService);

        controller.processCalculation();

    }
}
