package calculator;

import calculator.domain.Calculator;

public class OriginalSeparatorStrategy implements CalculatorStrategy {

    Calculator calculator = new Calculator();

    public void calculate(String inputText) {
        String arr[] = calculator.extractNumber(inputText);
        int totalSum = calculator.sum(arr);
        System.out.println("결과 : " + totalSum);
    }
}
