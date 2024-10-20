package calculator.factory;

import calculator.strategy.CalcDelimiterStrategyMap;
import calculator.strategy.CalcDelimiterStrategyType;
import calculator.strategy.CalculatorDelimiterStrategy;
import calculator.strategy.CustomCalcDelimiterStrategy;
import calculator.strategy.DefaultCalcDelimiterStrategy;

public class CalculatorStrategyFactory implements CalculatorFactory {
    private final CalcDelimiterStrategyMap strategyMap;

    public CalculatorStrategyFactory() {
        this.strategyMap = new CalcDelimiterStrategyMap();
        strategyMap.addStrategy(CalcDelimiterStrategyType.DEFAULT, new DefaultCalcDelimiterStrategy());
        strategyMap.addStrategy(CalcDelimiterStrategyType.CUSTOM_DELIMITER, new CustomCalcDelimiterStrategy());
    }

    @Override
    public CalculatorDelimiterStrategy selectStrategy(CalcDelimiterStrategyType type) {
        return strategyMap.getStrategy(type);
    }
}
