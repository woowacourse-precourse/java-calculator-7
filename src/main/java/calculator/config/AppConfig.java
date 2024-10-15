package calculator.config;

import calculator.adapters.input.cli.CliCalculationController;
import calculator.application.ports.input.InputReader;
import calculator.adapters.input.InputReaderImpl;
import calculator.application.ports.output.OutputWriter;
import calculator.adapters.output.OutputWriterImpl;
import calculator.application.service.CalculateStringCommand;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class AppConfig {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CliCalculationController cliCalculationController;
    private CalculateStringUseCase calculateStringUseCase;

    public AppConfig() {
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
        this.calculateStringUseCase = new CalculateStringCommand(
            new InputValidator()
        );
        this.cliCalculationController = new CliCalculationController(
            inputReader,
            outputWriter,
            calculateStringUseCase
        );
    }

    public CliCalculationController cliCalculationController() {
        return cliCalculationController;
    }
}
