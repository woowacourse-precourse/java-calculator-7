package calculator;

import calculator.config.BeanConfig;
import calculator.controller.CalculatorController;
import calculator.dto.CalculationResultDTO;
import calculator.view.InputView;
import calculator.view.OutputView;

public final class FrontController {
    private final CalculatorController calculatorController;

    public FrontController() {
        this.calculatorController = BeanConfig.getBean(CalculatorController.class);
    }

    void run() {
        String input = InputView.enterNumbers();
        CalculationResultDTO resultDTO = calculatorController.calculate(input);
        OutputView.printResult(resultDTO);
    }
}
