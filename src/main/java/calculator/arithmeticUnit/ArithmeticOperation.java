package calculator.arithmeticUnit;

import calculator.operator.Operand;

import java.util.function.BinaryOperator;

public abstract class ArithmeticOperation {
    private final BinaryOperator<Integer> operator;

    protected ArithmeticOperation(BinaryOperator<Integer> operator) {
        this.operator = operator;
    }

    public Operand execute(Operand leftOperand, Operand rightOperand) {
        int resultValue =  operator.apply(leftOperand.getValue(), rightOperand.getValue());
        return Operand.of(resultValue);
    }

    public BinaryOperator<Integer> getOperator() {
        return operator;
    }
}
