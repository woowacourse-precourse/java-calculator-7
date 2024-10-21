package calculator.controller;

import calculator.domain.UserExpression;
import calculator.domain.UserExpressionDivide;
import calculator.repository.DelimiterRepository;

public class ExpressionController {

    private UserExpression userExpression;
    private DelimiterRepository delimiterRepository;

    private void createExpression(UserExpression userExpression) {
        this.userExpression = userExpression;
        delimiterRepository = new DelimiterRepository();
    }

    private void divideUserExpression() {
        UserExpressionDivide.dividePart(userExpression);
    }
}
