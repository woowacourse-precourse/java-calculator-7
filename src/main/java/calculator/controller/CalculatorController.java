package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomCalculator;
import calculator.model.DefaultCalculator;
import calculator.view.OutputView;

public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController(String input) {
        this.calculator = selectCalculator(input);
    }

    public void run(){
        calculator.validateExpression();
        calculator.extractNumber();
        int result = calculator.sum();
        OutputView.getOutputMessage(result);
    }

    private Calculator selectCalculator(String input) {
        if (input.matches("^//.\\\\n.*")) {
            return new CustomCalculator(input);
        }
        return new DefaultCalculator(input);
    }

}
