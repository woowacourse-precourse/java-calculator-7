package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    CalculatorService service = new CalculatorService();

    public void input() {
        service.input();
    }

    public void calculate() {
        service.findCustomDelimiter();
        service.deleteDelimiter();
    }

    public void output() {
        service.output();
    }
}
