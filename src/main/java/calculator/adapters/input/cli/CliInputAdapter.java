package calculator.adapters.input.cli;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.request.Request;
import calculator.port.input.InputPort;
import camp.nextstep.edu.missionutils.Console;

public class CliInputAdapter implements InputPort {

    @Override
    public Request readRequest() {
        String input = Console.readLine();
        return new CalculationRequest(input);
    }
}