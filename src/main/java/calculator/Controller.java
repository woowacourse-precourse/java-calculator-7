package calculator;

import calculator.service.InputHandler;
import calculator.service.SeparatorHandler;
import calculator.service.Calculator;

public class Controller {
    private final InputHandler inputHandler;
    private final SeparatorHandler separatorHandler;
    private final Calculator calculator;

    public Controller() {
        this.inputHandler = new InputHandler();
        this.separatorHandler = new SeparatorHandler();
        this.calculator = new Calculator();
    }

    public void run(){
        String input = inputHandler.getUserInput();

        input = separatorHandler.checkCustomSeparator(input);

        inputHandler.validateInput(input);

        int result = calculator.calculate(input);
    }
}
