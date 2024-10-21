package calculator.service.strategy.defaultstrategy;

import calculator.dto.CalculationRequestDTO;
import calculator.model.PositiveNumber;
import calculator.model.delimiter.Delimiter;
import calculator.service.strategy.CalculationStrategy;
import calculator.service.strategy.PositiveNumberExtractor;

public class DefaultDelimiterCalculationStrategy implements CalculationStrategy {
    private final PositiveNumberExtractor positiveNumberExtractor;

    public DefaultDelimiterCalculationStrategy(PositiveNumberExtractor positiveNumberExtractor) {
        this.positiveNumberExtractor = positiveNumberExtractor;
    }

    @Override
    public Long calculate(CalculationRequestDTO calculationRequestDTO) {
        String inputString = calculationRequestDTO.getInputString();
        PositiveNumber positiveNumber = positiveNumberExtractor.extractPositiveNumber(Delimiter.createDelimiter(),
                inputString);
        return positiveNumber.getPositiveNumberSum();
    }
}