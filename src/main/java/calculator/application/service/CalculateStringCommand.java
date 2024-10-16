package calculator.application.service;

import static calculator.infrastructure.constants.ResponseMessage.REQUEST_INPUT_MESSAGE;

import calculator.domain.service.AdditionService;
import calculator.ports.input.InputPort;
import calculator.ports.output.OutputPort;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class CalculateStringCommand implements CalculateStringUseCase {

    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final InputValidator inputValidator;
    private final AdditionService additionService;

    public CalculateStringCommand(InputPort inputPort, OutputPort outputPort,
        InputValidator inputValidator, AdditionService additionService) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
        this.additionService = additionService;
    }

    @Override
    public void calculate() {
        outputPort.printLine(REQUEST_INPUT_MESSAGE.getMessage());
        String input = inputPort.readLine();
        inputValidator.validate(input);

        additionService.compute(input);
    }
}
