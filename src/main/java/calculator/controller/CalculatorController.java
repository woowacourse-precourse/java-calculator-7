package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.model.StringProcessor;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;
    private final StringProcessor stringProcessor;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();
        this.stringProcessor = new StringProcessor();
    }

    public int calculate(String input) {
        String[] numbers = stringProcessor.StringSplitter(input);
        int result = calculatorModel.add(numbers);
        return result;
    }

    public void startCalculator() {
        String input = calculatorView.getInput();
        int result = this.calculate(input);
        calculatorView.showOutput(result);
    }

}
