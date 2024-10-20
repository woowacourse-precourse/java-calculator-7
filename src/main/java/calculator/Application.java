package calculator;

import calculator.formatter.InputHandler;
import calculator.formatter.OutputHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputHandler.printInputPrompt();
        String input = InputHandler.input();

        Calculator calculator = new Calculator(input);
        int resultSum = calculator.sum();

        OutputHandler.printOutputResult(resultSum);
        InputHandler.close();
    }
}
