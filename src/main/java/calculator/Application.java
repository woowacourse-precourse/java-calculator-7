package calculator;

import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputClass inputClass = new InputClass();
        CalculatorService calculatorService = new CalculatorService();

        String inputText = inputClass.input();
        if (inputClass.existCustomSeparator(inputText)) {
            calculatorService.calculateContainCustomSeparator(inputText);
        }
        if (!inputClass.existCustomSeparator(inputText)){
            calculatorService.calculateContainOriginalSeparator(inputText);
        }
    }
}