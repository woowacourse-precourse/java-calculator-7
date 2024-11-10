package calculator.controller.factory;

import calculator.model.expression.CustomExpression;
import calculator.model.expression.DefaultExpression;
import calculator.model.expression.Expression;

public final class ExpressionFactory {  // 큰 변화는 없을 것으로 예상하여 Factory 사용

    private ExpressionFactory() {
    }

    public static Expression createExpression(final String input) {
        if (input.startsWith(CustomExpression.CUSTOM_DELIMITER_PREFIX)) {
            return new CustomExpression(input);
        }
        return new DefaultExpression(input);
    }
}
