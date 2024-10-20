package calculator.expression;

import calculator.operator.Operand;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;

import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Objects;

public class Expression {
    private static final int OPERAND_TO_SEPARATOR_DIFFERENCE = 1;
    private final CustomDeque<Separator> separatorDeque;
    private final CustomDeque<Operand> operandDeque;

    public Expression(CustomDeque<Separator> separatorDeque, CustomDeque<Operand> operandDeque) {
        validate(separatorDeque, operandDeque);
        this.separatorDeque = separatorDeque;
        this.operandDeque = operandDeque;
    }

    private void validate(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        if (!isOperandToSeparatorCountValid(separatorDeque, operandDeque)) {
            throw new IllegalArgumentException("Invalid expression: separator operand count does not match");
        }
    }

    private boolean isOperandToSeparatorCountValid(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        return OPERAND_TO_SEPARATOR_DIFFERENCE == operandDeque.size() - separatorDeque.size();
    }

    public Operand peekFirstOperand() {
        return operandDeque.peek();
    }

    public Operand peekSecondOperand() {
        if (operandDeque.size() < 2){
            throw new NoSuchElementException("Expression has only one operand");
        }
        Iterator<Operand> iterator = operandDeque.iterator();
        iterator.next();
        return iterator.next();
    }

    public Separator peekFirstSeparator() {
        if (separatorDeque.isEmpty()) {
            throw new NoSuchElementException("Empty separator");
        }
        return separatorDeque.peek();
    }

    public Expression updateFirstOperationResult(Operand firstOperationResult) {
        consumeOperandsAndOperator();
        operandDeque.addFirst(firstOperationResult);
        return new Expression(new CustomDeque<>(separatorDeque), new CustomDeque<>(operandDeque));
    }

    private void consumeOperandsAndOperator() {
        operandDeque.poll();
        operandDeque.poll();
        separatorDeque.poll();
    }

    public boolean hasSeparator() {
        return separatorDeque.iterator()
                .hasNext();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return separatorDeque.equals(that.separatorDeque) && operandDeque.equals(that.operandDeque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(separatorDeque.toArray()), Arrays.hashCode(operandDeque.toArray()));
    }
}
