package calculator.infrastructure.config;

import calculator.presentation.CalculationController;
import calculator.presentation.CalculationUseCase;
import calculator.view.input.InputReader;
import calculator.view.input.InputReaderImpl;
import calculator.view.output.OutputWriter;
import calculator.view.output.OutputWriterImpl;

public class AppConfig {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CalculationUseCase calculationUseCase;

    public AppConfig() {
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
        this.calculationUseCase = new CalculationController(inputReader, outputWriter);
    }

    public InputReader inputReader() {
        return inputReader;
    }

    public OutputWriter outputWriter() {
        return outputWriter;
    }

    public CalculationUseCase calculationUseCase() {
        return calculationUseCase;
    }
}
