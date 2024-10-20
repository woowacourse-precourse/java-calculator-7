package calculator.service;

import calculator.domain.Expression;
import calculator.util.ExpressionParser;
import calculator.util.InputUtils;
import java.util.Arrays;

public class CalculatorService {
    public int sum(String input) {
        Expression expression = InputUtils.convertToExpression(input);
        int[] numbers = ExpressionParser.parseExpressionToIntArray(expression);
        return Arrays.stream(numbers).sum();
    }
}
