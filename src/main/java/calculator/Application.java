package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Declare Strategy Context Class, Calculator
        Calculator addCalculator = new Calculator(new Add());
        InputHandler inputHandler = new InputHandler();
        inputHandler.getUserInput();
        // inputHandler.setUserInput("//m\n1,2:3m2");
        inputHandler.setCustomSeparators();
        inputHandler.removeCustomSeparators();
        inputHandler.parseInput();
        addCalculator.setNumbers(inputHandler.getNumbers());
        System.out.println(addCalculator.calculate());
    }

}
