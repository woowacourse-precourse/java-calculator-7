package calculator.expression;

import calculator.operator.OperatorEnum;
import calculator.operator.OperatorMap;
import calculator.operator.Separator;
import calculator.arithmeticUnit.ArithmeticFunction;
import calculator.arithmeticUnit.ArithmeticProcessor;

import java.util.List;

public class ExpressionExecutor {
    private static final int EMPTY_EXPRESSION_RESULT = 0;
    private final OperatorMap operatorMap;

    public ExpressionExecutor(OperatorMap operatorMap) {
        this.operatorMap = operatorMap;
    }

    public int calculate(Expression expression) {
        if (isExpressionEmpty(expression)) {
            return EMPTY_EXPRESSION_RESULT;
        }
        while (!expression.isSeparatorEmpty()) {
            List<Integer> firstTwoOperands = expression.peekFirstTwoOperands();
            Separator separator = expression.peekFirstSeparator();
            ArithmeticFunction arithmeticFunction = getArithmeticFunctionBy(separator);
            int firstOperatorResult = ArithmeticProcessor.operate(arithmeticFunction, firstTwoOperands.get(0), firstTwoOperands.get(1));
            expression = expression.updateFirstOperationResult(firstOperatorResult);
        }
        return expression.peekFirstOperand();
    }

    private ArithmeticFunction getArithmeticFunctionBy(Separator separator) {
        OperatorEnum operatorEnum = operatorMap.getOperatorBySeparator(separator);
        return operatorEnum.getArithmeticFunction();
    }

    private boolean isExpressionEmpty(Expression expression) {
        return expression.isOperandEmpty() && expression.isSeparatorEmpty();
    }
}
