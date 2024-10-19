package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.UserInputParse;

import static calculator.view.InputView.userInput;
import static calculator.view.OutputView.printResult;
import static calculator.view.OutputView.startCalculator;

public class CalculatorController {
    public void run(){
        startCalculator();

        String userInput = userInput();
        UserInputParse userInputParse = new UserInputParse(userInput);
        Calculator calculator = new Calculator(userInputParse.getNumbers());
        Number sum = calculator.getSum();

        printResult(sum);
    }
}
