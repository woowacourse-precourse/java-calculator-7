package calculator.config;

import calculator.application.ports.input.InputPort;
import calculator.adapters.input.cli.CliInputAdapter;
import calculator.application.ports.output.OutputPort;
import calculator.adapters.output.cli.CliOutputAdapter;
import calculator.application.service.CalculateStringCommand;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class AppConfig {

    private InputPort inputPort;
    private OutputPort outputPort;
    private InputValidator inputValidator;
    private CalculateStringUseCase calculateStringUseCase;

    public AppConfig() {
        this.inputPort = new CliInputAdapter();
        this.outputPort = new CliOutputAdapter();
        this.inputValidator = new InputValidator();
        this.calculateStringUseCase = new CalculateStringCommand(inputPort, outputPort,
            inputValidator);
    }

    public CalculateStringUseCase getCalculateStringUseCase() {
        return calculateStringUseCase;
    }
}
