package calculator.calculator;

import calculator.validator.InputValidator;

public class NumberCalculator {
    public static int calc(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int parsedNumber = parseNumber(number);
            sum += parsedNumber;
        }
        return sum;
    }

    private static int parseNumber(String number){
        InputValidator.validateNumber(number);
        return Integer.parseInt(number);
    }
}
