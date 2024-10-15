package calculator.adapters.input.cli;

import calculator.application.ports.input.InputReader;
import calculator.application.ports.output.OutputWriter;

public class CliCalculationController {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public CliCalculationController(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void handle() {

    }
}
