package calculator;

import java.util.function.BinaryOperator;

public enum OperatorEnum {
    PLUS((leftOperand, rightOperand) -> leftOperand + rightOperand);

    private final BinaryOperator<Integer> biFunction;

    OperatorEnum(BinaryOperator<Integer> biFunction) {
        this.biFunction = biFunction;
    }

    public int operate(int leftOperand, int rightOperand) {
        return biFunction.apply(leftOperand, rightOperand);
    }
}
