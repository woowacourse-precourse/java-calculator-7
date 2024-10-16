package calculator.infrastructure.config;

import calculator.domain.service.AdditionService;
import calculator.port.input.InputPort;
import calculator.adapters.input.cli.CliInputAdapter;
import calculator.port.output.OutputPort;
import calculator.adapters.output.cli.CliOutputAdapter;
import calculator.application.service.CalculateStringCommand;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class AppConfig {

    private InputPort inputPort;
    private OutputPort outputPort;
    private InputValidator inputValidator;
    private AdditionService additionService;
    private CalculateStringUseCase calculateStringUseCase;

    public AppConfig() {
        this.inputPort = new CliInputAdapter();
        this.outputPort = new CliOutputAdapter();
        this.inputValidator = new InputValidator();
        this.additionService = new AdditionService();
        this.calculateStringUseCase = new CalculateStringCommand(
            inputPort,
            outputPort,
            inputValidator,
            additionService);
    }

    public CalculateStringUseCase getCalculateStringUseCase() {
        return calculateStringUseCase;
    }
}
