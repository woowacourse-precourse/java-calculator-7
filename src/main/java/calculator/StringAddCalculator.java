package calculator;

import java.util.List;

public class StringAddCalculator {
    InputProcessor inputProcessor = new InputProcessor();
    MessagePrinter messagePrinter = new MessagePrinter();


    public void run() {
        messagePrinter.printInputRequest();
        inputProcessor.readInput();

        StringParser stringParser = new StringParser(inputProcessor.getInput());
        List<Integer> numbers = stringParser.parse();



    }
}
