package calculator.utils;

import calculator.model.CalculatorValues;
import java.util.regex.Pattern;

public class IntegerExtractor {

    public static void extractIntegerFromExpression(CalculatorValues calculatorValues) {
        String[] tokens;

        if(calculatorValues.getDelimiter().equals("[,:]")){
            tokens = calculatorValues.getExpression()
                    .split(calculatorValues.getDelimiter());
        }
        else{
            tokens = calculatorValues.getExpression()
                    .split(Pattern.quote(calculatorValues.getDelimiter()));
        }
        for(String token : tokens){
            calculatorValues.addNumbersFromInputByDelimiter(token);
        }
    }
}