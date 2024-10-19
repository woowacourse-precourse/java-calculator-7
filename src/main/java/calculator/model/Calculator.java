package calculator.model;

import calculator.validation.Validator;

public class Calculator {
    public String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (String token : splitedNumbers) {
            int number = Validator.parseNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
