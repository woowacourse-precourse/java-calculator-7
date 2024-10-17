package calculator.service;

import calculator.domain.Expression;

public class CalculatorService {
    public static int add(String input) {
        if (input == "") {
            return 0;
        }
        Expression expression = new Expression(input);
        return expression.calculateSum();
    }
}
