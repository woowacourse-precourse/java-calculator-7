package calculator.service;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculateRequest;
import calculator.dto.response.CalculateResponse;
import calculator.util.InputHandler;
import calculator.util.OutputHandler;

public class CalculatorStarter {

    private final CalculatorController calculatorController = new CalculatorController();

    public void calculate() {
        String input = InputHandler.consoleInput();
        CalculateResponse result=CalculateResponse.from(0);

        if (!input.isEmpty()) {
            result = calculatorController.calculate(CalculateRequest.from(input));
        }

        OutputHandler.consoleOutput(result);
    }
}
