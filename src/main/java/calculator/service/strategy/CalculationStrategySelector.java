package calculator.service.strategy;

import calculator.dto.CalculationRequestDTO;

public class CalculationStrategySelector {
    private final CalculationStrategy defaultDelimiterCalculationStrategy;
    private final CalculationStrategy defatulWithCustomDelimiterCalculationStrategy;

    public CalculationStrategySelector(CalculationStrategy defaultDelimiterCalculationStrategy,
                                       CalculationStrategy defatulWithCustomDelimiterCalculationStrategy) {
        this.defaultDelimiterCalculationStrategy = defaultDelimiterCalculationStrategy;
        this.defatulWithCustomDelimiterCalculationStrategy = defatulWithCustomDelimiterCalculationStrategy;
    }


    public CalculationStrategy selectStrategy(CalculationRequestDTO calculationRequestDTO) {
        String inputString = calculationRequestDTO.getInputString();
        CalculationInputValidator.validate(inputString);
        if (inputString.startsWith("//")) {
            return defatulWithCustomDelimiterCalculationStrategy;
        }
        return defaultDelimiterCalculationStrategy;
    }
}
