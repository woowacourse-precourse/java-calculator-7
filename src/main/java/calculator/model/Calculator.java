package calculator.model;

import calculator.validation.Validator;

public class Calculator {
    public static String plus(CustomDelimiter customDelimiter){
        Splitter splitter = new Splitter(customDelimiter);
        String[] splitedNumbers = splitter.getSplittedNumbers();
        int sumOfNumbers = 0;
        
        for (String token : splitedNumbers) {
            int number = Validator.parseNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
