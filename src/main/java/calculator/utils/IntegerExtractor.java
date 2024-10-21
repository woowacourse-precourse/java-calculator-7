package calculator.utils;

import calculator.model.CalculatorValues;

public class IntegerExtractor {

    public static void extractIntegerFromExpression(CalculatorValues calculatorValues) {
        String[] tokens = calculatorValues.getExpression().split(calculatorValues.getDelimiter());
        for(String token : tokens){
            calculatorValues.addNumbersFromInputByDelimiter(token);
        }
    }
}