package calculator.domain;

import calculator.domain.prompt.CalculatorPrompt;

public class Calculator {

    private final CalculatorPrompt calculatorPrompt;

    public Calculator(String inputData) {
        this.calculatorPrompt = new CalculatorPrompt(inputData);
    }

    public int sum() {
        return this.calculatorPrompt
                .extractInteger()
                .stream()
                .reduce(0, Integer::sum);
    }

}
