package calculator.io;

public class ConsoleIOHandler implements IOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    @Override
    public void startMessage() {
        outputHandler.startMessage();
    }

    @Override
    public String getUserInput() {
        return inputHandler.getUserInput();
    }

    @Override
    public void showResult(int result) {
        outputHandler.showResult(result);
    }
}
