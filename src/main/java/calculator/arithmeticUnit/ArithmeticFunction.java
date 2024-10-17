package calculator.arithmeticUnit;

import java.util.function.BinaryOperator;

public abstract class ArithmeticFunction {
    private final BinaryOperator<Integer> function;

    protected ArithmeticFunction(BinaryOperator<Integer> function) {
        this.function = function;
    }

    public BinaryOperator<Integer> getFunction() {
        return function;
    }
}
