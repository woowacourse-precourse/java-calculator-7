package calculator.service.strategy.customstrategy;

import calculator.dto.CalculationRequestDTO;
import calculator.model.PositiveNumber;
import calculator.service.strategy.CalculationStrategy;

public class DefaultAndCustomDelimiterCalculationStrategy implements CalculationStrategy {
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final PositiveNumberExtractor positiveNumberExtractor;

    public DefaultAndCustomDelimiterCalculationStrategy(CustomDelimiterExtractor customDelimiterExtractor,
                                                        PositiveNumberExtractor positiveNumberExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.positiveNumberExtractor = positiveNumberExtractor;
    }

    @Override
    public Long calculate(CalculationRequestDTO calculationRequestDTO) {
        String inputString = calculationRequestDTO.getInputString();
        PositiveNumber positiveNumber = positiveNumberExtractor.getPositiveNumberWithCustomDelimiter(
                customDelimiterExtractor.extractCustomDelimiter(inputString), inputString);
        return positiveNumber.getPositiveNumberSum();
    }
}
