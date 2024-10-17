package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CalculatorCustom;
import calculator.model.CalculatorImpl;
import calculator.view.View;

public class CalcController {

    public void run(){
        String userInput = View.getStringFromUser();
        Calculator calculator = new CalculatorCustom(userInput);
//        CalculatorImpl calculator = new CalculatorImpl(userInput);
        View.printResultToUser(calculator.calculate());
    }
}
