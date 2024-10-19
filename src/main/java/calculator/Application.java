package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String userInput = inputHandler.getInput();
        System.out.println(userInput);
        Parser parser = new Parser();
        String[] parsedTokens = parser.parseInput(userInput);
        //System.out.println(Arrays.toString(parsedTokens));
        PositiveNumberValidator validator = new PositiveNumberValidator();
        System.out.println("결과 : " + validator.addCalculator(parsedTokens));
    }
}
