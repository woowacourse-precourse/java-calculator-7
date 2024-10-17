package calculator.factory;

import calculator.strategy.CalcDelimiterStrategyType;
import calculator.strategy.CalculatorDelimiterStrategy;

public interface CalculatorFactory {
    CalculatorDelimiterStrategy selectStrategy(CalcDelimiterStrategyType type);
}
