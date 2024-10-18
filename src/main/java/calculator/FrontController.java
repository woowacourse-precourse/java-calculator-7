package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.response.CalculatorResponse;
import calculator.dto.request.CalculatorRequest;
import calculator.view.InputView;
import calculator.view.OutputView;

public final class FrontController {
    private final CalculatorController calculatorController;

    public FrontController(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    void run() {
        CalculatorRequest request = InputView.enterRequest();
        CalculatorResponse resultDTO = calculatorController.calculate(request);
        OutputView.printResult(resultDTO);
    }
}
