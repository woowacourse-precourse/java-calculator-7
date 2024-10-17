package calculator.service;

import calculator.factory.CalculatorStrategyFactory;
import calculator.strategy.CalcDelimiterStrategyType;
import calculator.strategy.CalculatorDelimiterStrategy;
import calculator.validate.CalculatorValidator;

public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorStrategyFactory strategyFactory;

    public CalculatorServiceImpl() {
        this.strategyFactory = new CalculatorStrategyFactory();
    }

    @Override
    public Integer calculate(String command) {
        if(command.isEmpty()) return 0;
        CalculatorValidator.validateExpression(command);
        CalculatorDelimiterStrategy strategy = selectStrategy(command);
        return strategy.execute(command);
    }

    private CalculatorDelimiterStrategy selectStrategy(String command) {
        if (CalculatorValidator.isCustomDelimiterExpression(command)) {
            return strategyFactory.selectStrategy(CalcDelimiterStrategyType.CUSTOM_DELIMITER);
        } else {
            return strategyFactory.selectStrategy(CalcDelimiterStrategyType.DEFAULT);
        }
    }
}
