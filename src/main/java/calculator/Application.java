package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Calculator calculator = new Calculator(inputHandler, outputHandler);
        calculator.run();
    }
}
