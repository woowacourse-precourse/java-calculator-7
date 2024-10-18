package calculator.controller;

import calculator.model.CalculatorModel;

public class CalculatorController {

    private final CalculatorModel calculatorModel;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
    }

    public int calculate(String input) {
        String[] numbers = calculatorModel.StringSplitter(input);
        int result = calculatorModel.add(numbers);
        return result;
    }

}
