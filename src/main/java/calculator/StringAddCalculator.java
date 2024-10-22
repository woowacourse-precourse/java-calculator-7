package calculator;

import java.util.List;

public class StringAddCalculator {
    InputProcessor inputProcessor = new InputProcessor();
    MessagePrinter messagePrinter = new MessagePrinter();
    Adder adder = new Adder();

    public void run() {
        messagePrinter.printInputRequest();
        String input = inputProcessor.readInput();

        StringParser stringParser = new StringParser(input);
        List<Integer> numbers = stringParser.parse();

        int result = adder.add(numbers);

        messagePrinter.printResult(result);
    }
}