package calculator.service;

import calculator.domain.Expression;
import calculator.domain.Tokens;
import calculator.util.NumberValidator;
import calculator.util.Parser;

public class CalculatorService {

    private final Parser parser = new Parser();
    private final NumberValidator numberValidator = new NumberValidator();

    public int calculate(Expression expression){
        if (expression.isNull()){
            return 0;
        }

        Tokens tokens = parser.parse(expression.getExpression());

        return sumNumbers(tokens.getTokens());
    }

    private int sumNumbers(String[] tokens){
        int sum = 0;

        for(String token : tokens){
            int number = numberValidator.validateNumber(token);
            sum += number;
        }
        return sum;
    }
}
