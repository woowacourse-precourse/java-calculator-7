package calculator.service;

import calculator.dto.response.CalculatorResponse;
import calculator.dto.request.CalculatorRequest;

public interface CalculatorService {
    CalculatorResponse calculateSum(CalculatorRequest request);
}
