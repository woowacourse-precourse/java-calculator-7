package calculator.view;

import calculator.common.ConsoleMessage;
import calculator.view.handler.InputHandler;
import calculator.view.handler.OutputHandler;

public class ApplicationConsoleView implements ApplicationView{

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public ApplicationConsoleView(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public String requestValue() {
        outputHandler.requestInputValue();
        return inputHandler.inputValue();
    }

    @Override
    public void printResult(int result) {
        outputHandler.printMessage(ConsoleMessage.RESULT_PREFIX + result);
    }
}
