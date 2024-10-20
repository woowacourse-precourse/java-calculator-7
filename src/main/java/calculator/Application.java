package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;

public class Application {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        CalculatorController calculatorController = new CalculatorController(calculatorService);

        calculatorController.run();
    }
}
