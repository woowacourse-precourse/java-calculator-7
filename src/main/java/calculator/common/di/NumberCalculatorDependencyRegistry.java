package calculator.common.di;

import calculator.service.NumberService;

public interface NumberCalculatorDependencyRegistry extends CalculatorDependencyRegistry {

    NumberService getNumberService();

    Class<? extends Number> getNumberClass();
}
