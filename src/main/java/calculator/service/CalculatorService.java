package calculator.service;

import calculator.dto.CalculationResultDTO;

public interface CalculatorService {
    CalculationResultDTO calculateSum(String input);
}
