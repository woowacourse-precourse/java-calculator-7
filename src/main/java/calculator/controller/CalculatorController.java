package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputParsing;

import static calculator.view.InputView.userInput;
import static calculator.view.OutputView.printResult;
import static calculator.view.OutputView.startCalculator;

public class CalculatorController {
    public void run(){
        startCalculator();

        String userInput = userInput();
        InputParsing inputParsing = new InputParsing(userInput);
        Calculator calculator = new Calculator(inputParsing.getNumbers());
        Number sum = calculator.getSum();

        printResult(sum);
    }
}
