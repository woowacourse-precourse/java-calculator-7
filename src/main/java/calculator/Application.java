package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;

public class Application {

    public static void main(String[] args) {
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        Calculator calculator = new Calculator(consoleInputHandler, consoleOutputHandler, delimiterExtractor);
        calculator.run();
    }

}
