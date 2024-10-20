package calculator.strategy;

import calculator.exception.InvalidDelimiterStrategyException;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class CalcDelimiterStrategyMap {
    private final Map<CalcDelimiterStrategyType, CalculatorDelimiterStrategy> strategyMap;

    public CalcDelimiterStrategyMap() {
        this.strategyMap = new EnumMap<>(CalcDelimiterStrategyType.class);
    }

    public void addStrategy(CalcDelimiterStrategyType type, CalculatorDelimiterStrategy strategy) {
        strategyMap.put(type, strategy);
    }

    public CalculatorDelimiterStrategy getStrategy(CalcDelimiterStrategyType type) {
        return Optional.ofNullable(strategyMap.get(type))
                .orElseThrow(InvalidDelimiterStrategyException::new);
    }
}
