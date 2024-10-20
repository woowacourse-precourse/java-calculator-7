package calculator.service;

import calculator.exception.InputExceptionHandler;
import calculator.model.Separator;

public class InputService {

    private final InputExceptionHandler exceptionHandler = new InputExceptionHandler();

    public String[] findCustomSeparator(String input) {
        String[] splitInput = new String[2];
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            splitInput[0] = input.substring(0, endIndex);
            splitInput[1] = input.substring(endIndex + 2);
        } else {
            splitInput[0] = null;
            splitInput[1] = input;
        }
        return splitInput;
    }

    public void handleInput(String[] inputSplit, Separator separator) {
        exceptionHandler.validateInputEmpty(inputSplit[1]);
        exceptionHandler.validateInputFormat(inputSplit);
        exceptionHandler.validateInputNumber(inputSplit, separator);
    }

    public String[] splitSeparator(String input, Separator separator) {
        String customSeparator = separator.getCustom();
        return input.split(separator.getComma() + "|" + separator.getColon() + "|" + customSeparator);
    }
}
