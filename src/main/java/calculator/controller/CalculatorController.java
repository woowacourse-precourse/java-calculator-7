package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceCustomImpl;
import calculator.view.View;

public class CalculatorController {

    public void run(){
        String userInput = View.getStringFromUser();
        CalculatorService calculator = new CalculatorServiceCustomImpl(userInput);
//        CalculatorImpl calculator = new CalculatorImpl(userInput);
        View.printResultToUser(calculator.calculate());
    }
}
