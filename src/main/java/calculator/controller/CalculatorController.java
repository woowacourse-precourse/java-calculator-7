package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController() {
        this.calculator = new Calculator();
    }

    public void run(){
        try{
            String input = CalculatorView.getInput();
            int result = calculator.add(input);
            CalculatorView.printResult(result);
        }
        catch (IllegalArgumentException e){
            CalculatorView.printError(e.getMessage());
        }
    }
}
