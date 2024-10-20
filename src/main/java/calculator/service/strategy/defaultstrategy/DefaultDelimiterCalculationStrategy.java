package calculator.service.strategy.defaultstrategy;

import calculator.dto.CalculationRequestDTO;
import calculator.model.PositiveNumber;
import calculator.service.strategy.CalculationStrategy;

public class DefaultDelimiterCalculationStrategy implements CalculationStrategy {
    private final PositiveNumberExtractor positiveNumberExtractor;

    public DefaultDelimiterCalculationStrategy(PositiveNumberExtractor positiveNumberExtractor) {
        this.positiveNumberExtractor = positiveNumberExtractor;
    }

    @Override
    public Long calculate(CalculationRequestDTO calculationRequestDTO) {
        String inputString = calculationRequestDTO.getInputString();
        PositiveNumber positiveNumber = positiveNumberExtractor.getPositiveNumber(inputString);
        return positiveNumber.getPositiveNumberSum();
    }
}
