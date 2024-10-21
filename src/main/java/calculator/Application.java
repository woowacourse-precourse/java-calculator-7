package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.ui.InputManager;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final InputManager inputManager = new InputManager(inputView, outputView);
        final CalculatorService calculatorService = new CalculatorService();
        final CalculatorController calculatorController = new CalculatorController(inputManager,outputView, calculatorService);
        calculatorController.start();
    }
}
