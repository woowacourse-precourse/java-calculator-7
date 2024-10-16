package calculator.service;

import calculator.domain.Calculator;

public class CalculatorService {
    Calculator calculator = new Calculator();

    public void calculateContainCustomSeparator(String inputText) {
        String customSeparator = calculator.findCustomSeparator(inputText);
        String text = calculator.removeCustomReserveWord(inputText);
        String arr[] = calculator.extractNumber(customSeparator, text);
        calculator.sum(arr);
    }

    public void calculateContainOriginalSeparator(String inputText) {
        String arr[] = calculator.extractNumber(inputText);
        calculator.sum(arr);

    }
}
