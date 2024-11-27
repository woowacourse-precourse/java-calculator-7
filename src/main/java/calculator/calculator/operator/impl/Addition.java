package calculator.calculator.operator.impl;

import calculator.calculator.operator.Operation;

public class Addition implements Operation {
    @Override
    public long operate(long a, long b) {
        return Math.addExact(a, b);
    }
}
