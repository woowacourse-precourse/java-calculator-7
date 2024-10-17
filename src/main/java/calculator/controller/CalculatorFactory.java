package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorFactory {
    public static CalculatorController createController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorService calculatorService = new CalculatorService();
        return new CalculatorController(inputView, outputView, calculatorService);
    }
}
