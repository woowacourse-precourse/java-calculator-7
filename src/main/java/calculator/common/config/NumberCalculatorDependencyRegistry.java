package calculator.common.config;

public interface NumberCalculatorDependencyRegistry extends CalculatorDependencyRegistry {

    Class<? extends Number> getNumberClass();
}
