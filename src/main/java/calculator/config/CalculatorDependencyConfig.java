package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.strategy.CalculationStrategy;
import calculator.service.strategy.CalculationStrategySelector;
import calculator.service.strategy.PositiveNumberExtractor;
import calculator.service.strategy.SplitPatternGenerator;
import calculator.service.strategy.customstrategy.CustomDelimiterExtractor;
import calculator.service.strategy.customstrategy.DefaultAndCustomDelimiterCalculationStrategy;
import calculator.service.strategy.defaultstrategy.DefaultDelimiterCalculationStrategy;

public class CalculatorDependencyConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculatorService());
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(calculatorStrategySelector());
    }

    private CalculationStrategySelector calculatorStrategySelector() {
        return new CalculationStrategySelector(defaultDelimiterCalculationStrategy(),
                defaultAndCustomDelimiterStrategy());
    }

    private CalculationStrategy defaultDelimiterCalculationStrategy() {
        return new DefaultDelimiterCalculationStrategy(positiveNumberExtractor());
    }

    private CalculationStrategy defaultAndCustomDelimiterStrategy() {
        return new DefaultAndCustomDelimiterCalculationStrategy(customDelimiterListExtractor(),
                positiveNumberExtractor());
    }

    private PositiveNumberExtractor positiveNumberExtractor() {
        return new PositiveNumberExtractor(splitStringMaker());
    }

    private SplitPatternGenerator splitStringMaker() {
        return new SplitPatternGenerator();
    }

    private CustomDelimiterExtractor customDelimiterListExtractor() {
        return new CustomDelimiterExtractor();
    }
}
