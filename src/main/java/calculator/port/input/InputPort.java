package calculator.port.input;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;

public interface InputPort {

    CalculationResponse process(CalculationRequest request);
}
