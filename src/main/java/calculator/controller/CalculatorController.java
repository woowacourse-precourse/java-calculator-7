package calculator.controller;

import calculator.model.AdditionCommand;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {
    CalculatorInputView calculatorInputView = new CalculatorInputView();
    CalculatorOutputView calculatorOutputView = new CalculatorOutputView();
    public void joinStrings(){
        calculatorOutputView.printAddGreetingMessage();
        AdditionCommand additionCommand = calculatorInputView.getAdditionCommand();
        double commandResult = additionCommand.exec();
    }
}
