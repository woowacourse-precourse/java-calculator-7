package calculator.factory;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.validator.CalculatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorFactory {

    public static CalculatorController createCalculatorController() {
        CalculatorValidator calculatorValidator = new CalculatorValidator();
        Calculator calculator = new Calculator(calculatorValidator);
        CalculatorService calculatorService = new CalculatorService(calculator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new CalculatorController(calculatorService, inputView, outputView);
    }
}
