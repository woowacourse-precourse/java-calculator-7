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
        Adder adder = new Adder();
        InputValidator inputValidator = new InputValidator();

        DelimiterStrategy defaultDelimiterStrategy = new DefaultDelimiterStrategy();
        DelimiterStrategy customDelimiterStrategy = new CustomDelimiterStrategy();

        Calculator calculator = new Calculator(
                inputHandler,
                outputHandler,
                adder,
                inputValidator,
                Arrays.asList(defaultDelimiterStrategy, customDelimiterStrategy)
        );

        calculator.run();
    }
}
