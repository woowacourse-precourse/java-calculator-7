package calculator;

import calculator.domain.Calculator;

public class OriginalSeparatorStrategy implements CalculatorStrategy {

    Calculator calculator = new Calculator();

    public void calculate(String inputText) {
        String arr[] = calculator.extractNumber(inputText);
        calculator.sum(arr);
    }
}
