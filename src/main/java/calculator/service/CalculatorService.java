package calculator.service;

import calculator.dto.CalculationRequestDTO;
import calculator.dto.CalculationResponseDTO;

public class CalculatorService {
    private final CalculationStrategySelector calculationStrategySelector;

    public CalculatorService(CalculationStrategySelector calculationStrategySelector) {
        this.calculationStrategySelector = calculationStrategySelector;
    }

    public CalculationResponseDTO calculate(String inputString) {
        CalculationRequestDTO calculationRequestDTO = createCalculationRequestDTO(inputString);
        CalculationStrategy strategy = calculationStrategySelector.selectStrategy(calculationRequestDTO);
        return createCalculationResponseDTO(strategy.calculate(calculationRequestDTO));
    }

    private CalculationRequestDTO createCalculationRequestDTO(String inputString) {
        return CalculationRequestDTO.createCalculationRequestDTO(inputString);
    }

    private CalculationResponseDTO createCalculationResponseDTO(Long sumResult) {
        return CalculationResponseDTO.createCalculationResponseDTO(sumResult);
    }
}
