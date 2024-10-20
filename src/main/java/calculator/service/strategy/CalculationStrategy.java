package calculator.service.strategy;

import calculator.dto.CalculationRequestDTO;

public interface CalculationStrategy {
    Long calculate(CalculationRequestDTO calculationRequestDTO);
}
