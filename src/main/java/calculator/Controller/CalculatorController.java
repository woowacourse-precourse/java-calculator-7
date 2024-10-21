package calculator.Controller;

import calculator.Service.CalculateService;
import calculator.View.Input;
import calculator.View.InputImpl;
import calculator.View.Output;
import calculator.View.OutputImpl;

public class CalculatorController {
    private final CalculateService calculateService;
    private final Input input;
    private final Output output;


    public CalculatorController(CalculateService calculateService) {
        this.calculateService = calculateService;
        this.input = new InputImpl();
        this.output = new OutputImpl();
    }

    public void run() {
        String inputString = input.getStringInput();
        int result = calculateService.calculate(inputString);
        output.printResult(result);

    }
}
