package calculator.controller;

import calculator.model.Calculator;
import calculator.view.View;

public class CalcController {

    private final Calculator calculator = new Calculator();

    public void run(){
        String userInput = View.getStringFromUser();
        int calcResult = calculator.calcResult(userInput);
        View.printResultToUser(calcResult);
    }
}
