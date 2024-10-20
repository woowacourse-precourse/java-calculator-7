package calculator;

import calculator.config.CalculatorDependencyConfig;
import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorDependencyConfig calculatorDependencyConfig = new CalculatorDependencyConfig();
        CalculatorController calculatorController = calculatorDependencyConfig.calculatorController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.outputCalculationResponseDTO(
                calculatorController.runCalculator(inputView.inputCalculationString()));
    }
}
