package calculator.service;

import calculator.dto.UserExpressionDto;

public interface CalculatorService {
    public void saveUserExpression(UserExpressionDto userExpressionDto);

    public int getExpressionResult();
}
