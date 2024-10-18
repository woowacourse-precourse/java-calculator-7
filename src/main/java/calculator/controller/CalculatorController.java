package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();
    }

    public int calculate(String input) {
        String[] numbers = calculatorModel.StringSplitter(input);
        int result = calculatorModel.add(numbers);
        return result;
    }

    public void startCalculator() {
        String input = calculatorView.getInput();
        int result = this.calculate(input);
    }

}
