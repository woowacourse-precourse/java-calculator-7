package calculator.service;

import calculator.domain.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public int calculate(Expression expression){
        if (expression.isNull()){
            return 0;
        }

        String input = expression.getExpression();
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
            if(matcher.matches()){
                String customDelimiter = matcher.group(1);
                delimiter =  DEFAULT_DELIMITERS + "|" + customDelimiter;
                numbers = matcher.group(2);
            }else{
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String[] tokens = numbers.split(delimiter);
        return sumNumbers(tokens);
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
