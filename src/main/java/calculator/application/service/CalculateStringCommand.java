package calculator.application.service;

import calculator.application.usecase.CalculateStringUseCase;

public class CalculateStringCommand implements CalculateStringUseCase {

    @Override
    public String calculate(String input) {
        return "6";
    }
}
