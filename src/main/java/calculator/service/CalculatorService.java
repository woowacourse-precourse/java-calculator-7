package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.util.NumberValidator;
import calculator.util.Parser;

public class CalculatorService {

    private Parser parser = new Parser();
    private NumberValidator numberValidator = new NumberValidator();

    public int calculate(Expression expression){
        if (expression.isNull()){
            return 0;
        }

        Calculator calculator = parser.parse(expression.getExpression());

        return sumNumbers(calculator.getNumbers());
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
