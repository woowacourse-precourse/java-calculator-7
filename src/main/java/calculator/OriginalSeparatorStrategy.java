package calculator;

import calculator.domain.Calculator;

public class OriginalSeparatorStrategy implements CalculatorStrategy {

    Calculator calculator = new Calculator();

    public void calculate(String inputText) {
        String arr[] = calculator.extractNumber(inputText);
        Double totalSum = calculator.sum(arr).doubleValue();
        if (checkFloatingPoint(totalSum)) {
            System.out.println("결과 : " + totalSum);
        }
        if (!checkFloatingPoint(totalSum)) {
            System.out.println("결과 : " + totalSum.intValue());
        }
    }

    private Boolean checkFloatingPoint(Double totalSum) {
        if (totalSum.intValue() == totalSum){
            return false;
        }
        return true;
    }
}
