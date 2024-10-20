package calculator.model;

import calculator.validation.Validator;

public class Calculator {
    public static String plus(FormulaHandler formulaHandler){
        String[] splitedNumbers = Splitter.splitNumbers(formulaHandler);
        int sumOfNumbers = 0;

        for (String token : splitedNumbers) {
            int number = Validator.parseNumber(token);
            sumOfNumbers += number;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
