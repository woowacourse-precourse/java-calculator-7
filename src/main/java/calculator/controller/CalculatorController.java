package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    public void run(){
        try{
            String input = CalculatorView.getInput();
        }
        catch (IllegalArgumentException e){
            CalculatorView.printError(e.getMessage());
        }
    }
}
