package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ConsoleView;

public class CalculatorController {
    private final Calculator calculator = new Calculator();
    private final ConsoleView view = new ConsoleView();

    public void run(){
        String input = view.request();
        int result = calculator.calc(input);
        try{
            view.printResult(result);
        }catch (IllegalArgumentException e){
            view.printError(e.getMessage());
        }
    }
}
