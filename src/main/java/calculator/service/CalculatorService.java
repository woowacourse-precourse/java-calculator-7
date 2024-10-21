package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.util.Parser;

public class CalculatorService {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private Parser parser = new Parser();
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
            int number = checkCorrectNumber(token);
            sum += number;
        }
        return sum;
    }

    private int checkCorrectNumber(String token){
        int number;
        try {
            number = Integer.parseInt(token);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다" + token);
        }
        return checkPositiveNumber(number);
    }

    private int checkPositiveNumber(int number){
        if (number < 0){
            throw new IllegalArgumentException("음수는 허용되지 않습니다." + number);
        }
        return number;
    }
}
