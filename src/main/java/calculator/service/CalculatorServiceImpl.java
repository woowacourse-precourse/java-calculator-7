package calculator.service;

import calculator.domain.ExpressionParser;
import calculator.dto.UserExpressionDto;

public class CalculatorServiceImpl implements CalculatorService {
    private ExpressionParser expressionParser;

    @Override
    public void saveUserExpression(UserExpressionDto userExpressionDto) {
        expressionParser = new ExpressionParser(userExpressionDto.getExpression());
    }

    @Override
    public int getExpressionResult() {
        return expressionParser.getAddResult();
    }
}
