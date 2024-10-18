package calculator.model;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;

public class DefaultCalculator implements Calculator{

    private CalculatorNumber calculatorNumber = new CalculatorNumber();
    private String defaultDelimiter = "[,:]";
    private String expression;

    public DefaultCalculator() {
    }

    public void insertInfo(String input) {
        this.expression = input;
    }

    public void extractNumber(){
        if (isExpressionEmpty()) {
            return;
        }
        String[] tokens = expression.split(defaultDelimiter);
        for(String token : tokens){
            calculatorNumber.addNumbersFromInputByDelimiter(Integer.parseInt(token));
        }
    }

    public int sum(){
        return calculatorNumber.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }

    public void validateExpression(){
        if(expression.isEmpty()){
            return;
        }
        if (expression.matches(".*-\\d+.*")) { // 양수만 입력 가능
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }
        if (!expression.matches("[0-9,|:]+")) { // 기본 구분자와 정수만 올 수 있음
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
        }
    }

    private boolean isExpressionEmpty() {
        if (expression.isEmpty()){
            calculatorNumber.addNumbersFromInputByDelimiter(0);
            return true;
        }
        return false;
    }

}
