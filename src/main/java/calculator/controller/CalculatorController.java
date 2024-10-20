package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.UserInput;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void run(){
        OutputView.printCommand();
        String input=InputView.enterInput();
        UserInput userInput=new UserInput(input);
        int result=userInput.startCalculate();
       OutputView.printResult(result);
    }
}
