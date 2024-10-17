package calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Expression {
    private final Deque<Separator> separatorDeque;
    private final Deque<Integer> operandDeque;

    public Expression(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        validate(separatorDeque, operandDeque);
        this.separatorDeque = separatorDeque;
        this.operandDeque = operandDeque;
    }

    private void validate(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        if (isIllegalExpression(separatorDeque, operandDeque)) {
            throw new IllegalArgumentException("Invalid expression: separator operand count does not match");
        }
    }

    private boolean isIllegalExpression(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        return !(isSeparatorOneLessThanOperand(separatorDeque, operandDeque) || isAllEmpty(separatorDeque, operandDeque));
    }

    private boolean isSeparatorOneLessThanOperand(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        int separatorCount = separatorDeque.size();
        int operandCount = operandDeque.size();
        return separatorCount + 1 == operandCount;
    }

    private boolean isAllEmpty(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        return separatorDeque.isEmpty() && operandDeque.isEmpty();
    }

    public List<Integer> peekFirstTwoOperands() {
        if(operandDeque.size() < 2) {
            throw new NoSuchElementException("has less than 2 operands");
        }
        int firstOperand = operandDeque.poll();
        int secondOperand = operandDeque.peek();
        operandDeque.addFirst(firstOperand);
        return List.of(firstOperand, secondOperand);
    }

    public int peekFirstOperand() {
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

    public Expression updateFirstOperationResult(int firstOperationResult) {
        consumeOperandsAndOperator();
        operandDeque.addFirst(firstOperationResult);
        return new Expression(new LinkedList<>(separatorDeque), new LinkedList<>(operandDeque));
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
}
