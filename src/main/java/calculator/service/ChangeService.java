package calculator.service;

import calculator.parser.InputParser;
import calculator.validator.InputValidator;

public class ChangeService {
    private final InputValidator inputValidator = InputValidator.getInstance();
    private final InputParser inputParser = InputParser.getInstance();

    public void BlankToZero(String[] separated) {
        inputValidator.validateZero(separated);
        inputParser.blankToZero(separated);
        inputValidator.validateInteger(separated);
    }
}
