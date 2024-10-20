package calculator;

import calculator.view.ConsoleInputHandler;
import calculator.view.ConsoleOutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(new ConsoleInputHandler(), new ConsoleOutputHandler());
        calculator.run();
    }
}
