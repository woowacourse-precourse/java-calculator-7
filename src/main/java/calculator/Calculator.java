package calculator;

import calculator.controller.CalculatorController;

public class Calculator {

    CalculatorController controller;

    public void run() {
        controller = new CalculatorController();

        controller.input();
        controller.calculate();
        controller.output();
    }
}
