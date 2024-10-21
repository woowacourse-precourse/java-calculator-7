package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.utils.InputValidator;
import calculator.view.OutputView;

public class CalculatorController {

    private final String input;
    private final Calculator calculator;

    public CalculatorController(String input) {
        this.input = input;
        this.calculator = new CalculatorImpl();
    }

    public void run(){
        InputValidator.validateInput(input);
        calculator.insertValues(input);
        calculator.extract();
        int result = calculator.sum();
        OutputView.getOutputMessage(result);
    }

}
