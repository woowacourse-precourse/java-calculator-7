package calculator.model;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;


public class CustomCalculator implements Calculator{

    private CalculatorNumber calculatorNumber = new CalculatorNumber();
    private String customDelimiter;
    private String expression;

    public CustomCalculator() {
    }

    public void insertInfo(String input){
        customDelimiter = String.valueOf(input.charAt(2));
        expression = input.substring(5);
    }

    public void extractNumber() {
        String[] tokens = expression.split(customDelimiter);
        for(String token : tokens){
            calculatorNumber.addNumbersFromInputByDelimiter(Integer.parseInt(token));
        }
    }

    public int sum() {
        return calculatorNumber.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }

    public void validateExpression(){
        validateNumbers();
        validateDelimiterUsage();
    }


    private void validateNumbers() {
        if (expression.matches(".*-\\d+.*")) {
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }
    }

    private void validateDelimiterUsage() {
        if(Character.isDigit(customDelimiter.charAt(0))) {
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_INTEGER);
        }
        // 입력 수식에서 설정된 커스텀 구분자 외에 다른 구분자가 사용되었는지 확인
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c) && !String.valueOf(c).equals(customDelimiter)) {
                throw new CalculatorException(CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_EXPRESSION);
            }
        }
    }
}
