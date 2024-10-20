package calculator.util;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorRun {
    public static void run() {
        InputView inputView = new InputView();
        CalculatorController calculatorController = new CalculatorController(new CalculatorService());

        String input = inputView.input();

        CalculatorResponse calculatorResponse = calculatorController.processInput(CalculatorRequest.from(input));

        OutputView.printOutput(calculatorResponse.result());
    }
}
