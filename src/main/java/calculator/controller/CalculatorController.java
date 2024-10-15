package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final StringCalculator stringCalculator;
    private final CalculatorView calculatorView;


    public CalculatorController() {
        this.stringCalculator = new StringCalculator();
        this.calculatorView = new CalculatorView();
    }

    public void run(){
        try {
            String input = calculatorView.getInput();

            int add = stringCalculator.add(input);
            calculatorView.printResult(add);

        }catch (IllegalArgumentException e){
            calculatorView.printError(e.getMessage());
        }
    }
}
