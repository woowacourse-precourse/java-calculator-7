package calculator.expression;

import calculator.operator.Operand;
import calculator.operator.Operator;
import calculator.operator.OperatorContainer;
import calculator.operator.Separator;

public class ExpressionExecutor {
    private final OperatorContainer operatorContainer;

    public ExpressionExecutor(OperatorContainer operatorContainer) {
        this.operatorContainer = operatorContainer;
    }

    public Operand calculate(Expression expression) {
        expression = useAllSeparator(expression);
        return expression.peekFirstOperand();
    }

    private Expression useAllSeparator(Expression expression) {
        while (expression.hasSeparator()) {
            Operand leftOperand = expression.peekFirstOperand();
            Operand rightOperand = expression.peekSecondOperand();
            Separator separator = expression.peekFirstSeparator();
            Operator operator = operatorContainer.getOperator(separator);
            Operand firstOperatorResult = operator.execute(leftOperand, rightOperand);
            expression = expression.updateFirstOperationResult(firstOperatorResult);
        }
        return expression;
    }
}
