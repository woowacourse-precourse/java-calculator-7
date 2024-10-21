package calculator.operation;

import calculator.model.LongCalculatorModel;

@FunctionalInterface
public interface LongCalculatorOperation {
    public void operate(LongCalculatorModel model);
}
