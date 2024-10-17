package calculator;

import calculation.Calculation;
import input.InputHandler;
import parser.InputParser;

public class Application {
    public static void main(String[] args) {

        Calculation calculator = Calculation.getInstance();
        InputParser parser = InputParser.getInstance();
        InputHandler inputHandler = new InputHandler();

        String input = inputHandler.getInput();
        String[] parseResult = parser.parse(input);

        int result = calculator.calculate(parseResult);
        System.out.println(result);

        inputHandler.closeInput();
    }
}
