package calculator;

import calculator.view.Input;
import calculator.view.Output;

public class Application {
    private static final Output output = new Output();
    private static final Input input = new Input();

    public static void main(String[] args) {
        output.printBeginningPhrase();
        String userInput = input.getInput();

    }
}
