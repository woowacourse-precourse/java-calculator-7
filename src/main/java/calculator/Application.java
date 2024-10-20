package calculator;

import calculator.calulate.Plus;
import calculator.delimiter.Delimiter;
import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class Application {

    private static final Output output = new Output();
    private static final Input input = new Input();
    private static final Delimiter delimiter = Delimiter.getInstance();
    private static final Plus plus = new Plus();

    public static void main(String[] args) {
        output.printBeginningPhrase();
        String userInput = input.getInput();
        List<String> strings = delimiter.divideCharacter(userInput);
        output.printResult(plus.getResult(strings));
    }
}
