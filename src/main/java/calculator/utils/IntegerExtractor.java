package calculator.utils;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;
import calculator.model.CalculatorValues;
import java.util.regex.Pattern;

public class IntegerExtractor {

    public static void extractIntegerFromExpression(CalculatorValues calculatorValues) {

        String delimiter = Pattern.quote(calculatorValues.getDelimiter());

        if (calculatorValues.getDelimiter().equals("[,:]")) {
            delimiter = calculatorValues.getDelimiter();  // 정규식 구분자는 그대로 사용
        }

        String[] tokens = calculatorValues.getExpression().split(delimiter);

        for (String token : tokens) {
            try{
                calculatorValues.addNumbersFromInputByDelimiter(token);
            }catch (IllegalArgumentException e){
                throw new CalculatorException(CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
            }
        }
    }
}