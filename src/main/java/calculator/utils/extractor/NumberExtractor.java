package calculator.utils.extractor;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;
import calculator.model.CalculatorValues;

public class NumberExtractor {

    public static void extractIntegerFromExpression(CalculatorValues calculatorValues) {

        String[] tokens = calculatorValues.getExpression().split(calculatorValues.getDelimiter());

        for (String token : tokens) {
            try{
                calculatorValues.addNumbersFromInputByDelimiter(token);
            }catch (IllegalArgumentException e){
                throw new CalculatorException(CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
            }
        }
    }
}