package calculator.application.usecase;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;

public interface CalculateStringUseCase {

    CalculationResponse calculate(CalculationRequest request);
}
