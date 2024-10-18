package calculator.model;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;

public class DefaultCalculator implements Calculator{

    private final CalculatorValues calculatorValues;

    public DefaultCalculator(String input) {
        this.calculatorValues = new CalculatorValues(
                input,
                "[,:]"
        );
    }

    public void extractNumber(){
        if (isExpressionEmpty()) {
            return;
        }
        String[] tokens = calculatorValues.getExpression().split(calculatorValues.getDelimiter());
        for(String token : tokens){
            calculatorValues.addNumbersFromInputByDelimiter(Integer.parseInt(token));
        }
    }

    public int sum(){
        return calculatorValues.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }

    public void validateExpression(){
        if(calculatorValues.getExpression().isEmpty()){
            return;
        }
        if (calculatorValues.getExpression().matches(".*-\\d+.*")) { // 양수만 입력 가능
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }
        if (!calculatorValues.getExpression().matches("[0-9,|:]+")) { // 기본 구분자와 정수만 올 수 있음
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
        }
    }

    private boolean isExpressionEmpty() {
        if (calculatorValues.getExpression().isEmpty()){
            calculatorValues.addNumbersFromInputByDelimiter(0);
            return true;
        }
        return false;
    }

}
