package calculator;

import calculator.arithmeticUnit.ArithmeticFunction;
import calculator.arithmeticUnit.PlusFunction;

public enum OperatorEnum {
    PLUS(PlusFunction.getInstance());

    private final ArithmeticFunction arithmeticFunction;

    OperatorEnum(ArithmeticFunction arithmeticFunction) {
        this.arithmeticFunction = arithmeticFunction;
    }

    public ArithmeticFunction getArithmeticFunction() {
        return arithmeticFunction;
    }
}
