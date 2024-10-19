package calculator.io;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
