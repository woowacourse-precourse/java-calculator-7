package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.service.NumbersService;
import calculator.service.SeparatorsService;

public class Application {
    public static void main(String[] args) {
        new CalculatorController(new SeparatorsService(),
                new NumbersService(),
                new Calculator())
                .run();
    } // main
} // class