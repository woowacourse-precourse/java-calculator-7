package calculator.strategy;

import calculator.exception.InvalidDelimiterStrategyException;
import java.util.HashMap;
import java.util.Map;

public class CalcDelimiterStrategyMap {
    private final Map<CalcDelimiterStrategyType, CalculatorDelimiterStrategy> strategyMap;

    public CalcDelimiterStrategyMap() {
        this.strategyMap = new HashMap<>();
    }

    public void addStrategy(CalcDelimiterStrategyType type, CalculatorDelimiterStrategy strategy) {
        strategyMap.put(type, strategy);
    }

    public CalculatorDelimiterStrategy getStrategy(CalcDelimiterStrategyType type) {
        if (!strategyMap.containsKey(type)) {
            throw new InvalidDelimiterStrategyException();
        }
        return strategyMap.get(type);
    }
}
