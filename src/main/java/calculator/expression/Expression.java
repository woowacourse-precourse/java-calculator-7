package calculator.expression;

import calculator.operator.Operand;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Objects;

public class Expression {
    private final CustomDeque<Separator> separatorDeque;
    private final CustomDeque<Operand> operandDeque;

    public Expression(CustomDeque<Separator> separatorDeque, CustomDeque<Operand> operandDeque) {
        validate(separatorDeque, operandDeque);
        this.separatorDeque = separatorDeque;
        this.operandDeque = operandDeque;
    }

    private void validate(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        if (isIllegalExpression(separatorDeque, operandDeque)) {
            throw new IllegalArgumentException("Invalid expression: separator operand count does not match");
        }
    }

    private boolean isIllegalExpression(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        return !(isSeparatorOneLessThanOperand(separatorDeque, operandDeque) || isAllEmpty(separatorDeque, operandDeque));
    }

    private boolean isSeparatorOneLessThanOperand(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        int separatorCount = separatorDeque.size();
        int operandCount = operandDeque.size();
        return separatorCount + 1 == operandCount;
    }

    private boolean isAllEmpty(Deque<Separator> separatorDeque, Deque<Operand> operandDeque) {
        return separatorDeque.isEmpty() && operandDeque.isEmpty();
    }

    public List<Operand> peekFirstTwoOperands() {
        if (operandDeque.size() < 2) {
            throw new NoSuchElementException("has less than 2 operands");
        }
        Iterator<Operand> iterator = operandDeque.iterator();
        Operand firstOperand = iterator.next();
        Operand secondOperand = iterator.next();
        return List.of(firstOperand, secondOperand);
    }

    public Operand peekFirstOperand() {
        if (operandDeque.isEmpty()) {
            throw new NoSuchElementException("Empty operand");
        }
        return operandDeque.peek();
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

    public boolean isSeparatorEmpty() {
        return separatorDeque.isEmpty();
    }

    public boolean isOperandEmpty() {
        return operandDeque.isEmpty();
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
