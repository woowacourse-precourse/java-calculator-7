package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.strategy.CalculationStrategy;
import calculator.service.strategy.CalculationStrategySelector;
import calculator.service.strategy.PatternMatcher;
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
                defaultAndCustomDelimiterCalculationStrategy());
    }

    private CalculationStrategy defaultDelimiterCalculationStrategy() {
        return new DefaultDelimiterCalculationStrategy(positiveNumberExtractor());
    }

    private CalculationStrategy defaultAndCustomDelimiterCalculationStrategy() {
        return new DefaultAndCustomDelimiterCalculationStrategy(customDelimiterExtractor(),
                positiveNumberExtractor());
    }

    private PositiveNumberExtractor positiveNumberExtractor() {
        return new PositiveNumberExtractor(splitPatternGenerator(), patternMatcher());
    }

    private SplitPatternGenerator splitPatternGenerator() {
        return new SplitPatternGenerator();
    }

    private CustomDelimiterExtractor customDelimiterExtractor() {
        return new CustomDelimiterExtractor(patternMatcher());
    }

    private PatternMatcher patternMatcher() {
        return new PatternMatcher();
    }
}
