package calculator.presentation;

import calculator.view.input.InputReader;
import calculator.view.output.OutputWriter;

public class CalculationController implements CalculationUseCase {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public CalculationController(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public String handleCalculation() {
        return "";
    }
}
