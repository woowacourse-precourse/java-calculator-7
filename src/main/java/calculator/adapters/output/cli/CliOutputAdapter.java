package calculator.adapters.output.cli;

import calculator.application.dto.response.CalculationResponse;
import calculator.application.dto.response.Response;
import calculator.port.output.OutputPort;

public class CliOutputAdapter implements OutputPort {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeResponse(Response response) {
        System.out.println(response.toString());
    }
}