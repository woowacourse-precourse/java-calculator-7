package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    CalculatorService service = new CalculatorService();

    public void input() {
        service.input();
    }

    public void getCustomDelimiter() {
        service.findCustomDelimiter();
    }

    public void removeDelimiter() {
        service.deleteDelimiter();
    }
}
