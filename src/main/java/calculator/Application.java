package calculator;

import calculator.context.Calculator;
import calculator.strategy.Add;
import calculator.parser.InputHandler;

public class Application {
    public static void main(String[] args) {
        // Declare Strategy Context Class, Calculator
        Calculator addCalculator = new Calculator(new Add());
        InputHandler inputHandler = new InputHandler();
        inputHandler.getUserInput();
        inputHandler.setCustomSeparators();
        inputHandler.removeCustomSeparators();
        inputHandler.parseInput();
        addCalculator.setNumbers(inputHandler.getNumbers());
        addCalculator.calculate();
    }

}
