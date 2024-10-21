package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;

public class CalculatorController {

    private final CalculatorService service = new CalculatorService();

    public void run() {
        String input = CalculatorInput.getInput();
        int result = service.initCalculator(input);
        CalculatorOutput.printResult(result);
    }

}
