package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.model.DelimiterParser;
import calculator.model.StringSplitter;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;
    private final StringSplitter stringSplitter;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();
        DelimiterParser delimiterParser = new DelimiterParser();
        this.stringSplitter = new StringSplitter(delimiterParser);
    }

    public int calculate(String input) {
        String[] numbers = stringSplitter.split(input);
        int result = calculatorModel.add(numbers);
        return result;
    }

    public void startCalculator() {
        String input = calculatorView.getInput();
        int result = this.calculate(input);
        calculatorView.showOutput(result);
    }

}