package calculator.controller;

import calculator.domain.Calculator;

public class CalculatorController {

    public void run() {
        Calculator calc = new Calculator("1,2;3");
        System.out.println(calc.sum());
    }
}
