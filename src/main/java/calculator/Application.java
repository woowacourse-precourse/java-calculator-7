package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        DelimiterStrategy defaultDelimiterStrategy = new DefaultDelimiterStrategy();
        DelimiterStrategy customDelimiterStrategy = new CustomDelimiterStrategy();

        Calculator calculator = new Calculator(
                inputHandler,
                outputHandler,
                Arrays.asList(defaultDelimiterStrategy, customDelimiterStrategy));

        calculator.run();
    }
}
