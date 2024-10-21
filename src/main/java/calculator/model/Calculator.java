package calculator.model;

import calculator.validation.Validator;

public class Calculator {
    public static String plus(FormulaHandler formulaHandler){
        String[] splittedNumbers = Splitter.splitNumbers(formulaHandler);
        int sumOfNumbers = 0;

        for (String token : splittedNumbers) {
            int number = Validator.parseNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
