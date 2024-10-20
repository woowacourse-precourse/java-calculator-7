package calculator;

import calculator.controller.Calculator;
import calculator.controller.io.ConsoleInputHandler;
import calculator.controller.io.ConsoleOutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(new ConsoleInputHandler(), new ConsoleOutputHandler());
        calculator.run();
    }
}
