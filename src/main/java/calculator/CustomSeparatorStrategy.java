package calculator;

import calculator.domain.Calculator;

public class CustomSeparatorStrategy implements CalculatorStrategy {

    Calculator calculator = new Calculator();

    public void calculate(String inputText) {
        String customSeparator = calculator.findCustomSeparator(inputText);
        String text = calculator.removeCustomReserveWord(inputText);
        String arr[] = calculator.extractNumber(customSeparator, text);
        calculator.sum(arr);
    }
}
