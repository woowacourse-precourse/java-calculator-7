package controller;

import calculator.domain.Calculator;
import calculator.input.UserInputHandler;

public class CalculatorController {
    private final UserInputHandler inputHandler;

    public CalculatorController() {
        this.inputHandler = new UserInputHandler();
    }

    public void start(){
        String input = inputHandler.userInput();
        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();
        System.out.println("결과 : " + result);

    }
}
