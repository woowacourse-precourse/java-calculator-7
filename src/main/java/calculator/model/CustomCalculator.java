package calculator.model;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;


public class CustomCalculator implements Calculator{

    private final CalculatorValues calculatorValues;

    public CustomCalculator(String input) {
        this.calculatorValues = new CalculatorValues(
                input.substring(5),
                String.valueOf(input.charAt(2))
        );
    }

    public void extractNumber() {
        String[] tokens = calculatorValues.getExpression()
                .split(calculatorValues.getDelimiter());
        for(String token : tokens){
            calculatorValues.addNumbersFromInputByDelimiter(Integer.parseInt(token));
        }
    }

    public int sum() {
        return calculatorValues.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }

    public void validateValues(){
        validateNumbers();
        validateDelimiterUsage();
    }


    private void validateNumbers() {
        if (calculatorValues.getExpression().matches(".*-\\d+.*")) {
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }
    }

    private void validateDelimiterUsage() {
        if(Character.isDigit(calculatorValues.getExpression().charAt(0))) {
            throw new CalculatorException(CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_INTEGER);
        }
        // 입력 수식에서 설정된 커스텀 구분자 외에 다른 구분자가 사용되었는지 확인
        for (char c : calculatorValues.getExpression().toCharArray()) {
            if (!Character.isDigit(c) && !String.valueOf(c).equals(calculatorValues.getDelimiter())) {
                throw new CalculatorException(CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_EXPRESSION);
            }
        }
    }
}
