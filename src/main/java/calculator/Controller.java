package calculator;

import calculator.service.InputHandler;
import calculator.service.SeparatorHandler;

public class Controller {
    private final InputHandler inputHandler;
    private final SeparatorHandler separatorHandler;

    public Controller() {
        this.inputHandler = new InputHandler();
        this.separatorHandler = new SeparatorHandler();
    }

    public void run(){
        String input = inputHandler.getUserInput();

        input = separatorHandler.checkCustomSeparator(input);
    }
}
