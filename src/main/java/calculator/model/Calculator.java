package calculator.model;

import calculator.validation.InputValidator;

public class Calculator {
    public String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (String token : splitedNumbers) {
            int number = InputValidator.parsePositiveNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
