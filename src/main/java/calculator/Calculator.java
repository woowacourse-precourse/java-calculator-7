package calculator;

import calculator.service.CalculatorManager;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;

public class Calculator {
    private final CalculatorInput calculatorInput;
    private final CalculatorOutput calculatorOutput;

    public Calculator() {
        calculatorInput = new CalculatorInput();
        calculatorOutput = new CalculatorOutput();
    }

    public void run() {
        calculatorOutput.printInput();
        final String input = calculatorInput.read();

        final CalculatorManager calculatorManager = new CalculatorManager(input);

        calculatorOutput.printResult(calculatorManager.calculateSum());
    }
}
