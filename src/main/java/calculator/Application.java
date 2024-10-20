package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorService);
        calculatorController.execute();
    }
}
