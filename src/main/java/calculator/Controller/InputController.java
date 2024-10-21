package calculator.Controller;

import calculator.vaildator.InputValidator;
import calculator.vaildator.SeparatorHandler;

public class InputController {

    private final SeparatorHandler separatorHandler = new SeparatorHandler();
    private final InputValidator inputValidator = new InputValidator();

    public String[] processInput(String input) {
        String separator = separatorHandler.getCustomSeparator(input);
        String[] inputArr = separatorHandler.splitInput(input, separator);
        inputValidator.validateInputArray(inputArr);
        return inputArr;
    }
}
