package calculator.service.strategy;

import calculator.dto.CalculationRequestDTO;
import calculator.validator.ValidationUtils;

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
        ValidationUtils.validateStartWithDoubleSlash(inputString);
        if (inputString.startsWith("//")) {
            return defatulWithCustomDelimiterCalculationStrategy;
        }
        return defaultDelimiterCalculationStrategy;
    }
}
