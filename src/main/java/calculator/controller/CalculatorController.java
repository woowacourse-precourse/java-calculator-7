package calculator.controller;

import calculator.service.CalculateService;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {
    private final CalculateService calculateService;
    private final Input input;
    private final Output output;


    public CalculatorController(CalculateService calculateService, Input input, Output output) {
        this.calculateService = calculateService;
        this.input = input;
        this.output = output;
    }

    public void run() {
        String inputString = input.getStringInput();
        int result = calculateService.calculate(inputString);
        output.printResult(result);

    }
}
