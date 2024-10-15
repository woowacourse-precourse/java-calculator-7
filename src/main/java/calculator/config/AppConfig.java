package calculator.config;

import calculator.adapters.input.cli.CliCalculationController;
import calculator.application.ports.input.InputReader;
import calculator.adapters.input.InputReaderImpl;
import calculator.application.ports.output.OutputWriter;
import calculator.adapters.output.OutputWriterImpl;

public class AppConfig {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CliCalculationController cliCalculationController;

    public AppConfig() {
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
        this.cliCalculationController = new CliCalculationController(inputReader, outputWriter);
    }

    public InputReader inputReader() {
        return inputReader;
    }

    public OutputWriter outputWriter() {
        return outputWriter;
    }

    public CliCalculationController cliCalculationController() {
        return cliCalculationController;
    }
}
