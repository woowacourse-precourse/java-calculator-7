package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.validator.CalculatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;


public class Application {
    public static void main(String[] args) {
        CalculatorValidator validator = new CalculatorValidator();
        Calculator calculator = new Calculator(validator);
        CalculatorService calculatorService = new CalculatorService(calculator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController controller = new CalculatorController(calculatorService, inputView, outputView);
        controller.run();
    }
}
