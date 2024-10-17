package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService stringTokenService;
    public CalculatorController(CalculatorService stringTokenService) {
        this.stringTokenService = stringTokenService;
    }

    public void run()
    {
        stringTokenService.run();
    }
}
