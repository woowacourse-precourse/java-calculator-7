package calculator.controller;

import calculator.service.Calculator;
import calculator.view.UserInput;
import calculator.view.UserOutput;

public class CalController {
    UserInput userInput = new UserInput();
    Calculator calculator = new Calculator();
    UserOutput userOutput = new UserOutput();

    public void play() {
        String input = userInput.input();
        int sum = calculator.sum(input);
        userOutput.printResult(sum);
    }
}
