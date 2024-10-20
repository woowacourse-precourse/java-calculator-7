package calculator.controller;

import calculator.model.AdditionCommand;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {
    CalculatorInputView calculatorInputView = new CalculatorInputView();
    CalculatorOutputView calculatorOutputView = new CalculatorOutputView();
    public void execAdditionCommand(){
        calculatorOutputView.printAddGreetingMessage();
        String commandInput = calculatorInputView.getCommandInput();
        AdditionCommand additionCommand = new AdditionCommand(commandInput);
        double commandResult = additionCommand.exec();
        calculatorOutputView.printAdditionResult(commandResult);
    }
}
