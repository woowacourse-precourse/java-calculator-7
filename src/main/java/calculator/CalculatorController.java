package calculator;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorInput calculatorInput;
    private final CalculatorOutput calculatorOutput;

    public CalculatorController(Calculator calculator, CalculatorInput calculatorInput, CalculatorOutput calculatorOutput) {
        this.calculator = calculator;
        this.calculatorInput = calculatorInput;
        this.calculatorOutput = calculatorOutput;
    }
    public void run() {
        try {
            String input = calculatorInput.getInput();
            int result = calculator.splitAndSum(input);
            calculatorOutput.printResult(result);
        } catch (IllegalArgumentException e) {
            calculatorOutput.printError(e.getMessage());
        }
    }

}

