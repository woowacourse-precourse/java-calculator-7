package calculator;

public class StringAddCalculator {
    InputProcessor inputProcessor = new InputProcessor();
    MessagePrinter messagePrinter = new MessagePrinter();

    public void run() {
        messagePrinter.printInputRequest();

        inputProcessor.readInput();
    }
}
