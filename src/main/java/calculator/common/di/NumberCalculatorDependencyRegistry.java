package calculator.common.di;

import calculator.model.number.service.NumberService;

public interface NumberCalculatorDependencyRegistry extends CalculatorDependencyRegistry {

    NumberService getNumberService();

    Class<? extends Number> getNumberClass();
}
