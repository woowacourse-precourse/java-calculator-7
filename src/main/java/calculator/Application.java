package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {

        CalculatorView calcView = new CalculatorView();
        CalculatorService calcService = new CalculatorService();
        CalculatorController calcController = new CalculatorController(calcView, calcService);

        calcController.start();
    }
}
