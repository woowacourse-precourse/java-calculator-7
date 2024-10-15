package calculator.controller;

import calculator.view.CalculatorOutputView;

public class CalculatorController {
    CalculatorOutputView calculatorOutputView = new CalculatorOutputView();
    public void joinStrings(){
        calculatorOutputView.printAddGreetingMessage();
    }
}
