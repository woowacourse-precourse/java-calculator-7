package calculator.model;

import calculator.validation.OperandValidator;

public class Calculator {
    public String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (String token : splitedNumbers) {
            int number = OperandValidator.parsePositiveNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
