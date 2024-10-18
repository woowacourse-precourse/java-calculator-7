package calculator.adapters.input.cli;

import static calculator.infrastructure.constants.ResponseMessage.REQUEST_INPUT_MESSAGE;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.port.input.InputPort;
import calculator.port.output.OutputPort;
import camp.nextstep.edu.missionutils.Console;

public class CliInputAdapter implements InputPort {

    private final OutputPort outputPort;
    private final CalculateStringUseCase calculateStringUseCase;

    public CliInputAdapter(OutputPort outputPort, CalculateStringUseCase calculateStringUseCase) {
        this.outputPort = outputPort;
        this.calculateStringUseCase = calculateStringUseCase;
    }

    public void run() {
        outputPort.writeMessage(REQUEST_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        CalculationRequest request = new CalculationRequest(input);

        CalculationResponse response = process(request);  // 유스케이스 실행
        outputPort.writeResponse(response);  // 결과 출력
    }

    @Override
    public CalculationResponse process(CalculationRequest request) {
        return calculateStringUseCase.calculate(request);
    }
}