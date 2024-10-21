package calculator;

import calculator.Controller.CalculatorController;
import calculator.Service.CalculateService;

public class Application {
    public static void main(String[] args) {
        CalculateService calculateService = new CalculateService();
        CalculatorController calculatorController = new CalculatorController(calculateService);
        calculatorController.run();
    }
}
