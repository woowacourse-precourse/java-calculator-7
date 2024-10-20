package calculator.controller;

import calculator.calculate.CalculateService;
import calculator.calculate.CalculateServiceImpl;
import calculator.separator.SeparatorService;
import calculator.separator.SeparatorServiceImpl;

public class CalculateController {
    private final SeparatorService separatorService;
    private final CalculateService calculateService;

    public CalculateController() {
        this.separatorService = new SeparatorServiceImpl();
        this.calculateService = new CalculateServiceImpl();
    }
}
