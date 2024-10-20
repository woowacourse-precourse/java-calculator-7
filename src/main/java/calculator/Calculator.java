package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

public class Calculator {

    private CalculatorController controller;

    public void run() {
        controller = new CalculatorController(new CalculatorService());

        controller.input();
        controller.calculate();
        controller.output();
    }
}
