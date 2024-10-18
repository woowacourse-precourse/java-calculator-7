package calculator.common.di;

public interface NumberCalculatorDependencyRegistry extends CalculatorDependencyRegistry {

    Class<? extends Number> getNumberClass();
}
