package calculator;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputClass inputClass = new InputClass();
        String inputText = inputClass.input();
        CalculatorStrategy calculatorStrategy;

        if (inputClass.existCustomSeparator(inputText)) {
            calculatorStrategy = new CustomSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }

        if (inputClass.existOriginalSeparator(inputText)) {
            calculatorStrategy = new OriginalSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }
    }
}