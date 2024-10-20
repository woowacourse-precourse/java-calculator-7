package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

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
