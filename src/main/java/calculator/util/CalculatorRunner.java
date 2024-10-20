package calculator.util;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorRunner {
    private static final CalculatorController calculatorController = new CalculatorController(new CalculatorService());

    public static void run() {
        String input = InputView.input();

        CalculatorResponse calculatorResponse = calculatorController.processInput(CalculatorRequest.from(input));

        OutputView.printOutput(calculatorResponse.result());
    }
}
