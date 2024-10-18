package calculator.expression;

import calculator.operator.Operand;
import calculator.operator.OperatorMap;
import calculator.operator.Separator;
import calculator.arithmeticUnit.ArithmeticOperation;

import java.util.List;

public class ExpressionExecutor {
    private static final Operand EMPTY_EXPRESSION_RESULT = Operand.of(0);
    private final OperatorMap operatorMap;

    public ExpressionExecutor(OperatorMap operatorMap) {
        this.operatorMap = operatorMap;
    }

    public Operand calculate(Expression expression) {
        if (isExpressionEmpty(expression)) {
            return EMPTY_EXPRESSION_RESULT;
        }
        while (!expression.isSeparatorEmpty()) {
            List<Operand> firstTwoOperands = expression.peekFirstTwoOperands();
            Separator separator = expression.peekFirstSeparator();
            ArithmeticOperation arithmeticOperation = operatorMap.getOperatorBySeparator(separator);
            Operand firstOperatorResult =  arithmeticOperation.execute(firstTwoOperands.get(0), firstTwoOperands.get(1));
            expression = expression.updateFirstOperationResult(firstOperatorResult);
        }
        return expression.peekFirstOperand();
    }

    private boolean isExpressionEmpty(Expression expression) {
        return expression.isOperandEmpty() && expression.isSeparatorEmpty();
    }
}
