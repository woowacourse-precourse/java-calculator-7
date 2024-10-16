package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.CalculationResultDTO;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

final class FrontController {
    private final CalculatorController calculatorController;

    FrontController() {
        this.calculatorController = new CalculatorController(new CalculatorService());
    }

    void run() {
        String input = InputView.enterNumbers();
        CalculationResultDTO resultDTO = calculatorController.calculate(input);
        OutputView.printResult(resultDTO);
    }
}
