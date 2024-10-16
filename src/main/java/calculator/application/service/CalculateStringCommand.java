package calculator.application.service;

import static calculator.infrastructure.constants.ResponseMessage.REQUEST_INPUT_MESSAGE;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.domain.service.AdditionService;
import calculator.port.input.InputPort;

import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;
import calculator.port.output.OutputPort;

public class CalculateStringCommand implements CalculateStringUseCase {

    private AdditionService additionService;
    private InputValidator inputValidator;
    private InputPort<CalculationRequest> inputPort;
    private OutputPort<CalculationResponse> outputPort;

    public CalculateStringCommand(InputPort inputPort, OutputPort outputPort, InputValidator inputValidator, AdditionService additionService) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
        this.additionService = additionService;
    }

    @Override
    public void calculate() {
        outputPort.writeMessage(REQUEST_INPUT_MESSAGE.getMessage());
        CalculationRequest request = inputPort.readRequest();

        inputValidator.validate(request);
        CalculationResponse response = additionService.compute(request);

        outputPort.writeResponse(response);
    }
}
