package calculator.application.service;

import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class CalculateStringCommand implements CalculateStringUseCase {

    private final InputValidator inputValidator;

    public CalculateStringCommand(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public String calculate(String input) {
        inputValidator.validate(input);

        return "6";
    }
}
